package com.spoonofcode.exchangerates.feature.exchangerate

import com.spoonofcode.exchangerates.core.navigation.ModuleRouteResolver
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.details.ExchangeRateDetailsScreen
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewScreen
import com.spoonofcode.exchangerates.navigation.ExchangeRateModule
import com.spoonofcode.exchangerates.navigation.Screen

internal class ExchangeRateRouteResolver : ModuleRouteResolver<ExchangeRateModule> {

    override fun resolve(screen: Screen): cafe.adriel.voyager.core.screen.Screen? =
        (screen as? ExchangeRateModule)?.let {
            when (it) {
                is ExchangeRateModule.ExchangeRateDetailsScreen -> ExchangeRateDetailsScreen(
                    rateCode = it.rateCode,
                    tableCode = it.tableCode,
                    currency = it.currency,
                )

                ExchangeRateModule.ExchangeRateOverviewScreen -> ExchangeRateOverviewScreen()
            }
        }
}