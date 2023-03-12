package com.example.geogame.core.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Translations(
    @Json(name = "ara")
    val ara: Ara = Ara(),
    @Json(name = "bre")
    val bre: Bre = Bre(),
    @Json(name = "ces")
    val ces: Ces = Ces(),
    @Json(name = "cym")
    val cym: Cym = Cym(),
    @Json(name = "deu")
    val deu: Deu = Deu(),
    @Json(name = "est")
    val est: Est = Est(),
    @Json(name = "fin")
    val fin: Fin = Fin(),
    @Json(name = "fra")
    val fra: FraX = FraX(),
    @Json(name = "hrv")
    val hrv: Hrv = Hrv(),
    @Json(name = "hun")
    val hun: Hun = Hun(),
    @Json(name = "ita")
    val ita: Ita = Ita(),
    @Json(name = "jpn")
    val jpn: Jpn = Jpn(),
    @Json(name = "kor")
    val kor: Kor = Kor(),
    @Json(name = "nld")
    val nld: Nld = Nld(),
    @Json(name = "per")
    val per: Per = Per(),
    @Json(name = "pol")
    val pol: Pol = Pol(),
    @Json(name = "por")
    val por: Por = Por(),
    @Json(name = "rus")
    val rus: Rus = Rus(),
    @Json(name = "slk")
    val slk: Slk = Slk(),
    @Json(name = "srp")
    val srp: Srp = Srp(),
    @Json(name = "swe")
    val swe: Swe = Swe(),
    @Json(name = "tur")
    val tur: Tur = Tur(),
    @Json(name = "urd")
    val urd: Urd = Urd(),
    @Json(name = "zho")
    val zho: Zho = Zho()
)