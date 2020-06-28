package com.dino.sfoide.enums

enum class Gender(val gender: String, val emoji: String) {
    UNKNOWN("", ""),
    MALE("male", "🙋‍♂️"),
    FEMALE("female", "🙋‍♀️");

    companion object {
        fun getGender(gender: String): Gender {
            return when (gender) {
                "male" -> MALE
                "female" -> FEMALE
                else -> UNKNOWN
            }
        }
    }
}