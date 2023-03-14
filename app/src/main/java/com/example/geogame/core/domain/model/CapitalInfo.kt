package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CapitalInfo(
    @Json(name = "latlng")
    val latlng: List<Double> = listOf()
)