package com.example.geogame.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val coreKoinModule = module {
    factory { CoroutineScope(SupervisorJob() + Dispatchers.Main) }
}