package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Name(
    @Json(name = "common")
    val common: String = "",
    @Json(name = "nativeName")
    val nativeName: NativeName = NativeName(),
    @Json(name = "official")
    val official: String = ""
)