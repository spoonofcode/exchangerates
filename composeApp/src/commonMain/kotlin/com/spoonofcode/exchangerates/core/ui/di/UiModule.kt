package com.spoonofcode.exchangerates.core.ui.di

import com.spoonofcode.exchangerates.core.ui.navigation.ViewModelNavigator
import com.spoonofcode.exchangerates.core.ui.navigation.ViewModelNavigatorImpl
import com.spoonofcode.exchangerates.core.ui.navigation.route.VoyagerRouteResolver
import com.spoonofcode.exchangerates.core.ui.navigation.route.VoyagerRouteResolverImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val uiModule = module {
    single { VoyagerRouteResolverImpl(getAll()) } bind VoyagerRouteResolver::class
    singleOf(::ViewModelNavigatorImpl).bind<ViewModelNavigator>()
}