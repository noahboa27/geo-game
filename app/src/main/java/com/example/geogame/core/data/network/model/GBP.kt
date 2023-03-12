package com.example.geogame.core.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GBP(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "symbol")
    val symbol: String = ""
)