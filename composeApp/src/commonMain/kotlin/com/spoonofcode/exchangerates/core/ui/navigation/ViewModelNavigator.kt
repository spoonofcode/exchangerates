package com.spoonofcode.exchangerates.core.ui.navigation

import cafe.adriel.voyager.core.screen.Screen
import kotlin.reflect.KClass

interface ViewModelNavigator {
    suspend fun pop()
    suspend fun popToRoot()
    suspend fun <T : Screen> popUpTo(screenClass: KClass<T>)
    suspend fun push(screen: Screen)
    suspend fun replaceAll(screens: List<Screen>)
}