package com.example.geogame.core.data.network.di

import com.example.geogame.core.data.network.api.RestCountriesApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.Duration

val retrofitModule = module {
    single { provideRetrofit(get()) }
    single { provideMoshi() }
    factory { HttpLoggingInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideRestCountriesApi(get()) }
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor)
        .build()

fun provideMoshi(): Moshi =
    Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

fun provideRestCountriesApi(retrofit: Retrofit): RestCountriesApi =
    retrofit.create(RestCountriesApi::class.java)

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://restcountries.com/v3.1/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
        .build()