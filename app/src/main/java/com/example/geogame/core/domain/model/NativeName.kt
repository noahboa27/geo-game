package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NativeName(
    @Json(name = "ara")
    val ara: Ara = Ara(),
    @Json(name = "eng")
    val eng: EngX = EngX(),
    @Json(name = "spa")
    val spa: Spa = Spa(),
    @Json(name = "swa")
    val swa: Swa = Swa()
)