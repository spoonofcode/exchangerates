package com.spoonofcode.exchangerates.feature.exchangerate.presentation.details

import androidx.compose.runtime.Immutable
import com.spoonofcode.exchangerates.core.ui.base.BaseViewState
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.model.RateMidWithDateUi

@Immutable
internal data class ExchangeRateDetailsViewState(
    val ratesMidWithDate: List<RateMidWithDateUi> = emptyList(),
    val currency: String = "",
    val rateCode: String = "",
) : BaseViewState()