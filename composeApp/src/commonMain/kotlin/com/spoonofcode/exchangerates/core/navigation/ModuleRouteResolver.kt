package com.spoonofcode.exchangerates.core.navigation

import com.spoonofcode.exchangerates.navigation.Screen


interface ModuleRouteResolver<ScreenType : Screen> {
    fun resolve(screen: Screen): cafe.adriel.voyager.core.screen.Screen? = null
}