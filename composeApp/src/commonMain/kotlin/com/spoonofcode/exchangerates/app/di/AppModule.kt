package com.spoonofcode.exchangerates.app.di

import com.spoonofcode.exchangerates.core.data.base.di.coreBaseModule
import com.spoonofcode.exchangerates.core.navigation.di.navigationModule
import com.spoonofcode.exchangerates.core.network.di.networkModule
import com.spoonofcode.exchangerates.core.ui.di.uiModule
import com.spoonofcode.exchangerates.feature.exchangerate.di.exchangeRateModule
import org.koin.dsl.module

val appModule = module {
    includes(
        // core
        coreBaseModule,
        navigationModule,
        networkModule,
        uiModule,

        // features
        exchangeRateModule,
    )
}