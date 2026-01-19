package com.spoonofcode.exchangerates.navigation

sealed class ExchangeRateModule : Screen() {
    data class ExchangeRateDetailsScreen(
        val rateCode: String,
        val tableCode: String,
        val currency: String
    ) : ExchangeRateModule()

    object ExchangeRateOverviewScreen : ExchangeRateModule()
}