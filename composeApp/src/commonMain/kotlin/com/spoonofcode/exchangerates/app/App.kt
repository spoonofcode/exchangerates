package com.spoonofcode.exchangerates.app

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.spoonofcode.exchangerates.core.ui.theme.AppTheme
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchnageRateOverviewScreen

@Composable
fun App() {
    AppTheme {
        Navigator(
            screens = listOf(ExchnageRateOverviewScreen())
        ) { navigator ->
            SlideTransition(navigator = navigator)
        }
    }
}