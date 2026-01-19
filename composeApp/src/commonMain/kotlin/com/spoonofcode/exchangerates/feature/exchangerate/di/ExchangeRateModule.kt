package com.spoonofcode.exchangerates.feature.exchangerate.di

import com.spoonofcode.exchangerates.core.ui.navigation.route.ModuleRouteResolver
import com.spoonofcode.exchangerates.feature.exchangerate.ExchangeRateRouteResolver
import com.spoonofcode.exchangerates.feature.exchangerate.data.ExchangeRatesRepositoryImpl
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.RemoteRatesDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.RemoteTableOfRatesDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.ExchangeRatesRepository
import com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase.GetAllExchangeRatesUseCase
import com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase.GetExchangeRateUseCase
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.details.ExchangeRateDetailsViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewViewModel
import com.spoonofcode.exchangerates.navigation.ExchangeRateModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val exchangeRateModule: Module = module {

    singleOf(::ExchangeRatesRepositoryImpl).bind<ExchangeRatesRepository>()

    singleOf(::RemoteTableOfRatesDataSource)
    singleOf(::RemoteRatesDataSource)

    factoryOf(::GetAllExchangeRatesUseCase)
    factoryOf(::GetExchangeRateUseCase)
    factoryOf(::ExchangeRateRouteResolver) { bind<ModuleRouteResolver<ExchangeRateModule>>() }

    viewModelOf(::ExchangeRateOverviewViewModel)
    viewModelOf(::ExchangeRateDetailsViewModel)
}