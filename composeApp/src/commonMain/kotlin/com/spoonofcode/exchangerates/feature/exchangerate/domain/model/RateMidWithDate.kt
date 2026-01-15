package com.spoonofcode.exchangerates.feature.exchangerate.domain.model

data class RateMidWithDate(
    val effectiveDate: String,
    val mid: Double,
)