package com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview

import androidx.compose.runtime.Immutable
import com.spoonofcode.exchangerates.core.ui.base.BaseViewState
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.Rate

@Immutable
internal data class ExchangeRateOverviewViewState(
    val rates: List<Rate> = emptyList(),
) : BaseViewState()