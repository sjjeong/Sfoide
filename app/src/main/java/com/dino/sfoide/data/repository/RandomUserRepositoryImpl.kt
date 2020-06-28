package com.dino.sfoide.data.repository

import com.dino.sfoide.data.model.UserInfoEntity
import com.dino.sfoide.data.source.RandomUserRemoteDataSource

class RandomUserRepositoryImpl(private val randomUserRemoteDataSource: RandomUserRemoteDataSource) :
    RandomUserRepository {
    override suspend fun getRandomUser(page: Int, results: Int): List<UserInfoEntity> {
        return randomUserRemoteDataSource.getRandomUser(page, results)
    }
}