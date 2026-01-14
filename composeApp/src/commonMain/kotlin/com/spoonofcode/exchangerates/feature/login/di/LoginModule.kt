package com.spoonofcode.exchangerates.feature.login.di

import com.spoonofcode.exchangerates.feature.login.data.LoginRepositoryImpl
import com.spoonofcode.exchangerates.feature.login.data.remote.RemoteLoginCodeDataSource
import com.spoonofcode.exchangerates.feature.login.domain.repository.LoginRepository
import com.spoonofcode.exchangerates.feature.login.domain.usecase.LoginCodeUseCase
import com.spoonofcode.exchangerates.feature.login.presentation.login.LoginViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val loginModule: Module = module {

    singleOf(::LoginRepositoryImpl).bind<LoginRepository>()

    singleOf(::RemoteLoginCodeDataSource)

    factoryOf(::LoginCodeUseCase)

    viewModelOf(::LoginViewModel)
}