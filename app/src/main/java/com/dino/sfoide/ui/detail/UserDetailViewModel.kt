package com.dino.sfoide.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dino.library.ui.DinoViewModel
import com.dino.library.util.Event
import com.dino.sfoide.model.UserInfoModel

class UserDetailViewModel(val userInfo: UserInfoModel) : DinoViewModel() {

    private val _callEvent = MutableLiveData<Event<String>>()
    val callEvent: LiveData<Event<String>> = _callEvent

    private val _sendEmailEvent = MutableLiveData<Event<String>>()
    val sendEmailEvent: LiveData<Event<String>> = _sendEmailEvent

    fun call(number: String) {
        _callEvent.value = Event(number)
    }

    fun sendEmail(emailAddress: String) {
        _sendEmailEvent.value = Event(emailAddress)
    }

}