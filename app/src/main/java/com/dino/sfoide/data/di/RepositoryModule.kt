package com.dino.sfoide.data.di

import com.dino.sfoide.data.repository.RandomUserRepository
import com.dino.sfoide.data.repository.RandomUserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<RandomUserRepository> { RandomUserRepositoryImpl(get()) }
}