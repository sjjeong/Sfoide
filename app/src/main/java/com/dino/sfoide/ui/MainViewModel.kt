package com.dino.sfoide.ui

import androidx.lifecycle.viewModelScope
import com.dino.library.ext.logE
import com.dino.library.ext.toJson
import com.dino.library.ui.DinoViewModel
import com.dino.sfoide.data.repository.RandomUserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val randomUserRepository: RandomUserRepository) : DinoViewModel() {

    init {
        viewModelScope.launch {
            val userInfoList = randomUserRepository.getRandomUser(1, 20)
            logE(userInfoList.toJson())
        }
    }

}