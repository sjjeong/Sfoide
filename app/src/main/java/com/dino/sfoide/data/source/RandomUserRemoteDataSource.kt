package com.dino.sfoide.data.source

import com.dino.sfoide.data.model.UserInfoEntity

interface RandomUserRemoteDataSource {

    suspend fun getRandomUser(page: Int, results: Int): List<UserInfoEntity>

}