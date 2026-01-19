package com.spoonofcode.exchangerates.core.navigation.di

import com.spoonofcode.exchangerates.core.navigation.VoyagerRouteResolver
import com.spoonofcode.exchangerates.core.navigation.VoyagerRouteResolverImpl
import dev.jordond.connectivity.Connectivity
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationModule: Module = module {
    single {
        Connectivity {
            autoStart = true
        }
    }
    single { VoyagerRouteResolverImpl(getAll()) } bind VoyagerRouteResolver::class
}