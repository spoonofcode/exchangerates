package com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class RatesMidWithDateResponse(
    val table: String,
    val currency: String,
    val code: String,
    val rates: List<RateMidWithDateResponse>,
)

@Serializable
data class RateMidWithDateResponse(
    val no: String,
    val effectiveDate: String,
    val mid: Double,
)