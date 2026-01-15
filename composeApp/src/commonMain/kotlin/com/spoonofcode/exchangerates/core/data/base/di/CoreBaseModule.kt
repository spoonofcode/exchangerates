package com.spoonofcode.exchangerates.core.data.base.di

import com.spoonofcode.exchangerates.core.data.base.DispatcherProvider
import org.koin.dsl.module

val coreBaseModule = module {
    single { DispatcherProvider.createDefaultDispatcherProvider() }
}