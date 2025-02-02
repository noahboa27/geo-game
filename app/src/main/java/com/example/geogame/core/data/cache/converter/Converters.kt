package com.example.geogame.core.data.cache.converter

import android.content.ComponentCallbacks
import android.content.res.Configuration
import androidx.room.TypeConverter
import com.example.geogame.core.domain.model.*
import com.squareup.moshi.Moshi
import org.koin.android.ext.android.inject

class Converters: ComponentCallbacks {
    val moshi: Moshi by inject()
    private val carAdapter = moshi.adapter(Car::class.java)!!
    private val coatOfArmsAdapter = moshi.adapter(CoatOfArms::class.java)!!
    private val currenciesAdapter = moshi.adapter(Currencies::class.java)!!
    private val flagsAdapter = moshi.adapter(Flags::class.java)!!
    private val languagesAdapter = moshi.adapter(Languages::class.java)!!
    private val mapsAdapter = moshi.adapter(Maps::class.java)!!
    private val nameAdapter = moshi.adapter(Name::class.java)!!

    @TypeConverter
    fun fromStringList(list: List<String>): String =
        list.toString()

    @TypeConverter
    fun toStringList(s: String): List<String> =
        s.trim('[', ']').split(", ")

    @TypeConverter
    fun fromCar(car: Car): String =
        carAdapter.toJson(car)

    @TypeConverter
    fun toCar(s: String): Car =
        carAdapter.fromJson(s) ?: Car()

    @TypeConverter
    fun fromCoatOfArms(coa: CoatOfArms): String =
        coatOfArmsAdapter.toJson(coa)

    @TypeConverter
    fun toCoatOfArms(s: String): CoatOfArms =
        coatOfArmsAdapter.fromJson(s) ?: CoatOfArms()

    @TypeConverter
    fun fromCurrencies(currencies: Currencies): String =
        currenciesAdapter.toJson(currencies)

    @TypeConverter
    fun toCurrencies(s: String): Currencies =
        currenciesAdapter.fromJson(s) ?: Currencies()

    @TypeConverter
    fun fromFlags(flags: Flags): String =
        flagsAdapter.toJson(flags)

    @TypeConverter
    fun toFlags(s: String): Flags =
        flagsAdapter.fromJson(s) ?: Flags()

    @TypeConverter
    fun fromLanguages(languages: Languages): String =
        languagesAdapter.toJson(languages)

    @TypeConverter
    fun toLanguages(s: String): Languages =
        languagesAdapter.fromJson(s) ?: Languages()

    @TypeConverter
    fun fromMaps(maps: Maps): String =
        mapsAdapter.toJson(maps)

    @TypeConverter
    fun toMaps(s: String): Maps =
        mapsAdapter.fromJson(s) ?: Maps()

    @TypeConverter
    fun fromName(name: Name): String =
        nameAdapter.toJson(name)

    @TypeConverter
    fun toName(s: String): Name =
        nameAdapter.fromJson(s) ?: Name()

    override fun onConfigurationChanged(p0: Configuration) {}

    @Deprecated("Deprecated in Java")
    override fun onLowMemory() {}
}