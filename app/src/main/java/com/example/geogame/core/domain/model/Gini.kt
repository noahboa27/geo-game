package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Gini(
    @Json(name = "2017")
    val x2017: Double = 0.0,
    @Json(name = "2018")
    val x2018: Double = 0.0
)