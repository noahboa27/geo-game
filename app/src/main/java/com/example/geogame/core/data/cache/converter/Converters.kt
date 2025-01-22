package com.example.geogame.core.data.cache.converter

import android.content.ComponentCallbacks
import android.content.res.Configuration
import androidx.room.TypeConverter
import com.example.geogame.core.domain.model.*
import com.squareup.moshi.Moshi
import org.koin.android.ext.android.inject

class Converters: ComponentCallbacks {
    val moshi: Moshi by inject()
    private val capitalInfoAdapter = moshi.adapter(CapitalInfo::class.java)!!
    private val carAdapter = moshi.adapter(Car::class.java)!!
    private val coatOfArmsAdapter = moshi.adapter(CoatOfArms::class.java)!!
    private val currenciesAdapter = moshi.adapter(Currencies::class.java)!!
    private val demonymsAdapter = moshi.adapter(Demonyms::class.java)!!
    private val flagsAdapter = moshi.adapter(Flags::class.java)!!
    private val giniAdapter = moshi.adapter(Gini::class.java)!!
    private val iddAdapter = moshi.adapter(Idd::class.java)!!
    private val languagesAdapter = moshi.adapter(Languages::class.java)!!
    private val mapsAdapter = moshi.adapter(Maps::class.java)!!
    private val nameAdapter = moshi.adapter(Name::class.java)!!
    private val postalCodeAdapter = moshi.adapter(PostalCode::class.java)!!
    private val translationsAdapter = moshi.adapter(Translations::class.java)!!

    @TypeConverter
    fun fromStringList(list: List<String>): String =
        list.toString()

    @TypeConverter
    fun toStringList(s: String): List<String> =
        s.trim('[', ']').split(", ")

    @TypeConverter
    fun fromDoubleList(list: List<Double>): String =
        list.toString()

    @TypeConverter
    fun toDoubleList(s: String): List<Double> {
        val doubleList: MutableList<Double> = mutableListOf()
        val stringList = s.trim('[', ']').split(", ")
        for (string in stringList) {
            doubleList.add(string.toDouble())
        }

        return doubleList.toList()
    }

    @TypeConverter
    fun fromCapitalInfo(info: CapitalInfo): String =
        capitalInfoAdapter.toJson(info)

    @TypeConverter
    fun toCapitalInfo(s: String): CapitalInfo =
        capitalInfoAdapter.fromJson(s) ?: CapitalInfo()

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
    fun fromDemonyms(demonym: Demonyms): String =
        demonymsAdapter.toJson(demonym)

    @TypeConverter
    fun toDemonyms(s: String): Demonyms =
        demonymsAdapter.fromJson(s) ?: Demonyms()

    @TypeConverter
    fun fromFlags(flags: Flags): String =
        flagsAdapter.toJson(flags)

    @TypeConverter
    fun toFlags(s: String): Flags =
        flagsAdapter.fromJson(s) ?: Flags()

    @TypeConverter
    fun fromGini(gini: Gini): String =
        giniAdapter.toJson(gini)

    @TypeConverter
    fun toGini(s: String) =
        giniAdapter.fromJson(s) ?: Gini()

    @TypeConverter
    fun fromIdd(idd: Idd): String =
        iddAdapter.toJson(idd)

    @TypeConverter
    fun toIdd(s: String): Idd =
        iddAdapter.fromJson(s) ?: Idd()

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

    @TypeConverter
    fun fromPostalCode(postalCode: PostalCode): String =
        postalCodeAdapter.toJson(postalCode)

    @TypeConverter
    fun toPostalCode(s: String): PostalCode =
        postalCodeAdapter.fromJson(s) ?: PostalCode()

    @TypeConverter
    fun fromTranslations(translations: Translations): String =
        translationsAdapter.toJson(translations)

    @TypeConverter
    fun toTranslations(s: String): Translations =
        translationsAdapter.fromJson(s) ?: Translations()

    override fun onConfigurationChanged(p0: Configuration) {}

    @Deprecated("Deprecated in Java")
    override fun onLowMemory() {}
}