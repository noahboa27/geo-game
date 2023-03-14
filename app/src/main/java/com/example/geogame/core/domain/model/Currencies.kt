package com.example.geogame.core.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Currencies(
    @Json(name = "AED")
    val aED: AED = AED(),
    @Json(name = "GBP")
    val gBP: GBP = GBP(),
    @Json(name = "MXN")
    val mXN: MXN = MXN(),
    @Json(name = "TZS")
    val tZS: TZS = TZS(),
    @Json(name = "USD")
    val uSD: USD = USD()
)