package com.dino.sfoide.remote

import com.dino.sfoide.remote.model.RandomUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {

    @GET("/")
    suspend fun getRandomUser(
        @Query("page") page: Int,
        @Query("results") results: Int
    ): RandomUserResponse

}