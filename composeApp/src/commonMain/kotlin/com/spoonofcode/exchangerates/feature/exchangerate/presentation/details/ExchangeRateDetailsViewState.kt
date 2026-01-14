package com.spoonofcode.exchangerates.feature.exchangerate.presentation.details

import androidx.compose.runtime.Immutable
import com.spoonofcode.exchangerates.core.ui.base.BaseViewState

@Immutable
internal data class ExchangeRateDetailsViewState(
//    val email: String = "daria.waszkiewicz@gmail.com",
    val email: String = "luczak.bartosz5@gmail.com",
    val password: String = "daria123",
) : BaseViewState()