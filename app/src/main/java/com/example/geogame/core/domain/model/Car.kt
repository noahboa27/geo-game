package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Car(
    @Json(name = "side")
    val side: String = "",
    @Json(name = "signs")
    val signs: List<String> = listOf()
)