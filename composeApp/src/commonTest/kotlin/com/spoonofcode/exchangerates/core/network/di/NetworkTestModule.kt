package com.spoonofcode.exchangerates.core.network.di

import com.spoonofcode.exchangerates.core.network.networkManagerMock
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkTestModule = module {
    singleOf(::networkManagerMock)
}