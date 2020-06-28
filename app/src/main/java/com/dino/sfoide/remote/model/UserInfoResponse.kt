package com.dino.sfoide.remote.model

import com.dino.sfoide.data.model.UserInfoEntity
import com.google.gson.annotations.SerializedName

data class UserInfoResponse(
    @SerializedName("cell")
    val cell: String,
    @SerializedName("dob")
    val dob: Dob,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Id,
    @SerializedName("location")
    val location: Location,
    @SerializedName("login")
    val login: Login,
    @SerializedName("name")
    val name: Name,
    @SerializedName("nat")
    val nat: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("registered")
    val registered: Registered
) {

    fun toData() = UserInfoEntity(
        cell,
        dob.toData(),
        email,
        gender,
        id.toData(),
        location.toData(),
        login.toData(),
        name.toData(),
        nat,
        phone,
        picture.toData(),
        registered.toData()
    )

    data class Dob(
        @SerializedName("age")
        val age: Int,
        @SerializedName("date")
        val date: String
    ) {
        fun toData() = UserInfoEntity.Dob(age, date)
    }

    data class Id(
        @SerializedName("name")
        val name: String,
        @SerializedName("value")
        val value: String?
    ) {
        fun toData() = UserInfoEntity.Id(name, value)
    }

    data class Location(
        @SerializedName("city")
        val city: String,
        @SerializedName("coordinates")
        val coordinates: Coordinates,
        @SerializedName("country")
        val country: String,
        @SerializedName("postcode")
        val postcode: String,
        @SerializedName("state")
        val state: String,
        @SerializedName("street")
        val street: Street,
        @SerializedName("timezone")
        val timezone: Timezone
    ) {

        fun toData() = UserInfoEntity.Location(
            city,
            coordinates.toData(),
            country,
            postcode,
            state,
            street.toData(),
            timezone.toData()
        )

        data class Coordinates(
            @SerializedName("latitude")
            val latitude: Double,
            @SerializedName("longitude")
            val longitude: Double
        ) {
            fun toData() = UserInfoEntity.Location.Coordinates(latitude, longitude)
        }

        data class Street(
            @SerializedName("name")
            val name: String,
            @SerializedName("number")
            val number: Int
        ) {
            fun toData() = UserInfoEntity.Location.Street(name, number)
        }

        data class Timezone(
            @SerializedName("description")
            val description: String,
            @SerializedName("offset")
            val offset: String
        ) {
            fun toData() = UserInfoEntity.Location.Timezone(description, offset)
        }
    }

    data class Login(
        @SerializedName("md5")
        val md5: String,
        @SerializedName("password")
        val password: String,
        @SerializedName("salt")
        val salt: String,
        @SerializedName("sha1")
        val sha1: String,
        @SerializedName("sha256")
        val sha256: String,
        @SerializedName("username")
        val username: String,
        @SerializedName("uuid")
        val uuid: String
    ) {
        fun toData() = UserInfoEntity.Login(md5, password, salt, sha1, sha256, username, uuid)
    }

    data class Name(
        @SerializedName("first")
        val first: String,
        @SerializedName("last")
        val last: String,
        @SerializedName("title")
        val title: String
    ) {
        fun toData() = UserInfoEntity.Name(first, last, title)
    }

    data class Picture(
        @SerializedName("large")
        val large: String,
        @SerializedName("medium")
        val medium: String,
        @SerializedName("thumbnail")
        val thumbnail: String
    ) {
        fun toData() = UserInfoEntity.Picture(large, medium, thumbnail)
    }

    data class Registered(
        @SerializedName("age")
        val age: Int,
        @SerializedName("date")
        val date: String
    ) {
        fun toData() = UserInfoEntity.Registered(age, date)
    }
}
