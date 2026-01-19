package com.spoonofcode.exchangerates.core.coroutines.di

import com.spoonofcode.exchangerates.core.coroutines.DispatcherProvider
import org.koin.dsl.module

val coroutinesModule = module {
    single { DispatcherProvider.createDefaultDispatcherProvider() }
}