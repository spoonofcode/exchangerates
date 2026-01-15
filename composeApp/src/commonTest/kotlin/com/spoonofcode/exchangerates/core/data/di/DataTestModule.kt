package com.spoonofcode.exchangerates.core.data.di

import com.spoonofcode.exchangerates.core.data.repository.tableOfRatesRepositoryMock
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataTestModule = module {
    singleOf(::tableOfRatesRepositoryMock)
}