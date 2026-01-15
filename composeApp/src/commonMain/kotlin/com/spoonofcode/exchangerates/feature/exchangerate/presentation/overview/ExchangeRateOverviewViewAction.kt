package com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview

import com.spoonofcode.exchangerates.core.ui.base.BaseViewAction

internal sealed interface ExchangeRateOverviewViewAction : BaseViewAction {
    data object InitView : ExchangeRateOverviewViewAction
    data class SelectRate(val rateCode: String) : ExchangeRateOverviewViewAction
}