package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Flags(
    @Json(name = "alt")
    val alt: String = "",
    @Json(name = "png")
    val png: String = "",
    @Json(name = "svg")
    val svg: String = ""
)