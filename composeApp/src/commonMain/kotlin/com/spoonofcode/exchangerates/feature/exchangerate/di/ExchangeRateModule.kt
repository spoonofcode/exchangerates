package com.spoonofcode.exchangerates.feature.exchangerate.di

import com.spoonofcode.exchangerates.feature.exchangerate.data.TableOfRatesRepositoryImpl
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.RemoteRatesDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.RemoteTableOfRatesDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase.GetAllExchangeRatesUseCase
import com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase.GetExchangeRateUseCase
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.details.ExchangeRateDetailsViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val exchangeRateModule: Module = module {

    singleOf(::TableOfRatesRepositoryImpl).bind<TableOfRatesRepository>()

    singleOf(::RemoteTableOfRatesDataSource)
    singleOf(::RemoteRatesDataSource)

    factoryOf(::GetAllExchangeRatesUseCase)
    factoryOf(::GetExchangeRateUseCase)

    viewModelOf(::ExchangeRateOverviewViewModel)
    viewModelOf(::ExchangeRateDetailsViewModel)
}