package com.example.geogame.core.data.network.di

import com.example.geogame.core.data.network.api.RestCountriesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val retrofitModule = module {
    factory { HttpLoggingInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideRestCountriesApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl("https://restcountries.com/v3.1/").client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create()).build()

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()

fun provideRestCountriesApi(retrofit: Retrofit): RestCountriesApi =
    retrofit.create(RestCountriesApi::class.java)