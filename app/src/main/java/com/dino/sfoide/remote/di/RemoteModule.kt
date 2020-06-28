package com.dino.sfoide.remote.di

import com.dino.sfoide.data.source.RandomUserRemoteDataSource
import com.dino.sfoide.remote.RandomUserApi
import com.dino.sfoide.remote.impl.RandomUserRemoteDataSourceImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val remoteModule = module {
    single { get<Retrofit>().create<RandomUserApi>() }
    single<RandomUserRemoteDataSource> { RandomUserRemoteDataSourceImpl(get()) }
}