package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Demonyms(
    @Json(name = "eng")
    val eng: Eng = Eng(),
    @Json(name = "fra")
    val fra: Fra = Fra()
)