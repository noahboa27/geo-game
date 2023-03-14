package com.example.geogame

import com.example.geogame.core.data.di.dataModule
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify

@OptIn(KoinExperimentalAPI::class)
class CheckModulesTest : KoinTest {

    @Test
    fun checkAllModules() {
        dataModule.verify()
    }
}