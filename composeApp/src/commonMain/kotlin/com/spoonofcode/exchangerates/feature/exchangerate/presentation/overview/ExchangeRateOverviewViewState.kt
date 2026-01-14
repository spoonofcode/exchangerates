package com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview

import androidx.compose.runtime.Immutable
import com.spoonofcode.exchangerates.core.ui.base.BaseViewState

@Immutable
internal data class ExchangeRateOverviewViewState(
//    val email: String = "daria.waszkiewicz@gmail.com",
    val email: String = "luczak.bartosz5@gmail.com",
    val password: String = "daria123",
) : BaseViewState()