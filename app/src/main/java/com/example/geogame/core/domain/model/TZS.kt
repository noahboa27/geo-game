package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TZS(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "symbol")
    val symbol: String = ""
)