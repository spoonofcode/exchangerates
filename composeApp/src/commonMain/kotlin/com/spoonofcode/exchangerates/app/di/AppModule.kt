package com.spoonofcode.exchangerates.app.di

import com.spoonofcode.exchangerates.core.coroutines.di.coroutinesModule
import com.spoonofcode.exchangerates.core.network.di.networkModule
import com.spoonofcode.exchangerates.core.ui.di.uiModule
import com.spoonofcode.exchangerates.feature.exchangerate.di.exchangeRateModule
import org.koin.dsl.module

val appModule = module {
    includes(
        // core
        coroutinesModule,
        networkModule,
        uiModule,

        // features
        exchangeRateModule,
    )
}