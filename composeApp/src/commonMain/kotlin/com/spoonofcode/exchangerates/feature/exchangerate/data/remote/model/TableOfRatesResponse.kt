package com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class TableOfRatesResponse(
    val table: String,
    val no: String,
    val effectiveDate: String,
    val rates: List<RateResponse>,
)

@Serializable
data class RateResponse(
    val currency: String,
    val code: String,
    val mid: Double,
)