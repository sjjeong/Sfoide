package com.dino.sfoide.remote.model


import com.google.gson.annotations.SerializedName

data class RandomUserResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val userInfoList: List<UserInfoResponse>
) {
    data class Info(
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val results: Int,
        @SerializedName("seed")
        val seed: String,
        @SerializedName("version")
        val version: String
    )

}