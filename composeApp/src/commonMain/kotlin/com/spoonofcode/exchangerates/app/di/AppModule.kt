package com.spoonofcode.exchangerates.app.di

import com.spoonofcode.exchangerates.core.data.base.di.coreBaseModule
import com.spoonofcode.exchangerates.core.network.di.networkModule
import com.spoonofcode.exchangerates.core.ui.di.uiModule
import com.spoonofcode.exchangerates.feature.exchangerate.di.loginModule
import org.koin.dsl.module

val appModule = module {
    includes(
        // core
        coreBaseModule,
        networkModule,
        uiModule,

        // features
        loginModule,
    )
}