package com.spoonofcode.exchangerates.feature.exchangerate.di

import com.spoonofcode.exchangerates.core.data.di.dataTestModule
import com.spoonofcode.exchangerates.core.network.di.networkTestModule
import com.spoonofcode.exchangerates.core.ui.di.uiModule
import org.koin.dsl.module

val exchangeRateTestModule = module {
    includes(
        networkTestModule,
        dataTestModule,
        exchangeRateModule,
        uiModule,
    )
}