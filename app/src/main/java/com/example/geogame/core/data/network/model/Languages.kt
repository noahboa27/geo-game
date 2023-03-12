package com.example.geogame.core.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Languages(
    @Json(name = "ara")
    val ara: String = "",
    @Json(name = "eng")
    val eng: String = "",
    @Json(name = "spa")
    val spa: String = "",
    @Json(name = "swa")
    val swa: String = ""
)