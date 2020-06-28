package com.dino.sfoide.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dino.library.ui.DinoViewModel
import com.dino.library.util.Event
import com.dino.sfoide.data.repository.RandomUserRepository
import com.dino.sfoide.model.UserInfoModel
import com.dino.sfoide.model.toThumbnail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val randomUserRepository: RandomUserRepository) : DinoViewModel() {

    var page = 0
        private set

    private val _refreshLoading = MutableLiveData(false)
    val refreshLoading: LiveData<Boolean> = _refreshLoading

    private val _userInfoList = MutableLiveData<MutableList<UserInfoModel>>(mutableListOf())
    val userInfoList: LiveData<MutableList<UserInfoModel>> = _userInfoList

    private val _showUserDetail = MutableLiveData<Event<UserInfoModel>>()
    val showUserDetail: LiveData<Event<UserInfoModel>> = _showUserDetail

    private val _refreshEvent = MutableLiveData<Event<Unit>>()
    val refreshEvent: LiveData<Event<Unit>> = _refreshEvent

    init {
        load()
    }

    fun refresh() {
        page = 0
        _refreshLoading.value = true
        _refreshEvent.value = Event(Unit)
        load()
    }

    fun load() {
        page++
        viewModelScope.launch {
            launch(Dispatchers.Main) {
                showLoading()
            }
            val userInfoList = randomUserRepository.getRandomUser(page, 20).map { it.toThumbnail() }
            val newList = if (page == 1) {
                userInfoList.toMutableList()
            } else {
                _userInfoList.value?.apply { addAll(userInfoList) }
            }
            _userInfoList.postValue(newList)


            launch(Dispatchers.Main) {
                hideLoading()
                _refreshLoading.value = false
            }
        }
    }

    fun showUserDetail(userInfo: UserInfoModel) {
        _showUserDetail.value = Event(userInfo)
    }

}