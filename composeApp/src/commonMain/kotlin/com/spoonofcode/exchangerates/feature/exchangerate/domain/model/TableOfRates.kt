package com.spoonofcode.exchangerates.feature.exchangerate.domain.model

data class TableOfRates(
    val table: String,
    val no: String,
    val effectiveDate: String,
    val rates: List<Rate>,
)

data class Rate(
    val currency: String,
    val code: String,
    val mid: Double,
)