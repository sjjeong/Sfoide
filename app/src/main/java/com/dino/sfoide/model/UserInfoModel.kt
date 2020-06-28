package com.dino.sfoide.model

import com.dino.sfoide.data.model.UserInfoEntity
import com.dino.sfoide.enums.Flag
import com.dino.sfoide.enums.Gender

data class UserInfoModel(
    val fullName: String,
    val thumbnail: String,
    val flag: Flag,
    val gender: Gender,
    val age: Int,
    val phone: String,
    val cell: String,
    val email: String
)

fun UserInfoEntity.toThumbnail() =
    UserInfoModel(
        fullName = name.first + name.last,
        thumbnail = picture.medium,
        flag = Flag.getFlag(nat),
        gender = Gender.getGender(gender),
        age = dob.age,
        phone = phone,
        cell = cell,
        email = email
    )