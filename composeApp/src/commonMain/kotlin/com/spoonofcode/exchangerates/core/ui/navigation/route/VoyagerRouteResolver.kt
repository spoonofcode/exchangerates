package com.spoonofcode.exchangerates.core.ui.navigation.route

import com.spoonofcode.exchangerates.navigation.Screen

interface VoyagerRouteResolver {
    fun resolve(screen: Screen): cafe.adriel.voyager.core.screen.Screen
}