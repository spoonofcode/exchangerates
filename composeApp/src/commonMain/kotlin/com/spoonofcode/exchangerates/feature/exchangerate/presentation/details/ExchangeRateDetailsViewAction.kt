package com.spoonofcode.exchangerates.feature.exchangerate.presentation.details

import com.spoonofcode.exchangerates.core.ui.base.BaseViewAction

internal sealed interface ExchangeRateDetailsViewAction : BaseViewAction {
    data object InitView : ExchangeRateDetailsViewAction
}