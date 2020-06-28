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

    private val _userInfoList = MutableLiveData<List<UserInfoModel>>()
    val userInfoList: LiveData<List<UserInfoModel>> = _userInfoList

    private val _showUserDetail = MutableLiveData<Event<UserInfoModel>>()
    val showUserDetail: LiveData<Event<UserInfoModel>> = _showUserDetail

    init {
        initLoad()
    }

    private fun initLoad() {
        viewModelScope.launch {
            launch(Dispatchers.Main) {
                showLoading()
            }
            val userInfoList = randomUserRepository.getRandomUser(1, 20)
            _userInfoList.postValue(userInfoList.map { it.toThumbnail() })
            launch(Dispatchers.Main) {
                hideLoading()
            }
        }
    }

    fun showUserDetail(userInfo: UserInfoModel) {
        _showUserDetail.value = Event(userInfo)
    }

}