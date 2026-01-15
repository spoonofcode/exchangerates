package com.spoonofcode.exchangerates.feature.exchangerate.presentation.model

data class RateMidWithDateUi(
    val effectiveDate: String,
    val mid: Double,
    val isSignificantChange: Boolean,
)