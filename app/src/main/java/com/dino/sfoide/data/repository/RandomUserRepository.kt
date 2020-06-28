package com.dino.sfoide.data.repository

import com.dino.sfoide.data.model.UserInfoEntity

interface RandomUserRepository {

    suspend fun getRandomUser(page: Int, results: Int): List<UserInfoEntity>

}