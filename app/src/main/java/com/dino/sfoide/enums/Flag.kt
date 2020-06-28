package com.dino.sfoide.enums

enum class Flag(val code: String, val emoji: String) {
    UNKNOWN("", ""),
    AU("AU", "\uD83C\uDDE6\uD83C\uDDFA"),
    BR("BR", "\uD83C\uDDE7\uD83C\uDDF7"),
    CA("CA", "\uD83C\uDDE8\uD83C\uDDE6"),
    CH("CH", "\uD83C\uDDE8\uD83C\uDDED"),
    DE("DE", "\uD83C\uDDE9\uD83C\uDDEA"),
    DK("DK", "\uD83C\uDDE9\uD83C\uDDF0"),
    ES("ES", "\uD83C\uDDEA\uD83C\uDDF8"),
    FI("FI", "\uD83C\uDDEB\uD83C\uDDEE"),
    FR("FR", "\uD83C\uDDEB\uD83C\uDDF7"),
    GB("GB", "\uD83C\uDDEC\uD83C\uDDE7"),
    IE("IE", "\uD83C\uDDEE\uD83C\uDDEA"),
    IR("IR", "\uD83C\uDDEE\uD83C\uDDF7"),
    NO("NO", "\uD83C\uDDF3\uD83C\uDDF4"),
    NL("NL", "\uD83C\uDDE7\uD83C\uDDF6"),
    NZ("NZ", "\uD83C\uDDF3\uD83C\uDDFF"),
    TR("TR", "\uD83C\uDDF9\uD83C\uDDF7"),
    US("US", "\uD83C\uDDFA\uD83C\uDDF8");

    companion object {
        fun getFlag(code: String): Flag {
            return when (code) {
                "AU" -> AU
                "BR" -> BR
                "CA" -> CA
                "CH" -> CH
                "DE" -> DE
                "DK" -> DK
                "ES" -> ES
                "FI" -> FI
                "FR" -> FR
                "GB" -> GB
                "IE" -> IE
                "IR" -> IR
                "NO" -> NO
                "NL" -> NL
                "NZ" -> NZ
                "TR" -> TR
                "US" -> US
                else -> UNKNOWN
            }
        }
    }
}