package com.spoonofcode.exchangerates.feature.exchangerate.presentation.mappers

import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.RateMidWithDate
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.model.RateMidWithDateUi
import kotlin.math.abs

fun RateMidWithDate.toRateMidWithDateUi(
    currentMid: Double,
    significantChangeThreshold: Double
): RateMidWithDateUi {
    val diff = abs(mid - currentMid)
    val percentDiff = if (currentMid != 0.0) diff / currentMid else 0.0

    return RateMidWithDateUi(
        effectiveDate = effectiveDate,
        mid = mid,
        isSignificantChange = percentDiff > significantChangeThreshold
    )
}
