package com.dino.sfoide.remote.impl

import com.dino.sfoide.data.model.UserInfoEntity
import com.dino.sfoide.data.source.RandomUserRemoteDataSource
import com.dino.sfoide.remote.RandomUserApi

class RandomUserRemoteDataSourceImpl(private val randomUserApi: RandomUserApi) :
    RandomUserRemoteDataSource {
    override suspend fun getRandomUser(page: Int, results: Int): List<UserInfoEntity> {
        return randomUserApi.getRandomUser(page, results)
            .userInfoList
            .map { it.toData() }
    }
}