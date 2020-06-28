package com.dino.sfoide.di

import com.dino.sfoide.model.UserInfoModel
import com.dino.sfoide.ui.MainViewModel
import com.dino.sfoide.ui.detail.UserDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
    viewModel { (userInfo: UserInfoModel) -> UserDetailViewModel(userInfo) }

}