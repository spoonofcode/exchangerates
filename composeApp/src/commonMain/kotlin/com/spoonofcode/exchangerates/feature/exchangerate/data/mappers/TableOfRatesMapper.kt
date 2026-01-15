package com.spoonofcode.exchangerates.feature.exchangerate.data.mappers

import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.RateMidWithDateResponse
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.RateResponse
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.Rate
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.RateMidWithDate

fun RateResponse.toRate(tableCode: String): Rate {
    return Rate(
        currency = currency,
        code = code,
        mid = mid,
        tableCode = tableCode,
    )
}

fun RateMidWithDateResponse.toRateMidWithDate(): RateMidWithDate {
    return RateMidWithDate(
        effectiveDate = effectiveDate,
        mid = mid,
    )
}