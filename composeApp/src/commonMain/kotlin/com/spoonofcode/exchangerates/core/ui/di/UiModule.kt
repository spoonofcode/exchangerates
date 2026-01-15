package com.spoonofcode.exchangerates.core.ui.di

import com.spoonofcode.exchangerates.core.ui.navigation.ViewModelNavigator
import com.spoonofcode.exchangerates.core.ui.navigation.ViewModelNavigatorImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val uiModule = module {
    singleOf(::ViewModelNavigatorImpl).bind<ViewModelNavigator>()
}