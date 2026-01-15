package com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase

import com.spoonofcode.exchangerates.core.utils.LocalDateTimeUtils
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.ExchangeRatesRepository
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.mappers.toRateMidWithDateUi
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.model.RateMidWithDateUi
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.minus

class GetExchangeRateUseCase(
    private val exchangeRatesRepository: ExchangeRatesRepository,
) {
    suspend operator fun invoke(
        rateCode: String,
        tableCode: String
    ): Result<List<RateMidWithDateUi>> {
        val today = LocalDateTimeUtils.now().date
        return exchangeRatesRepository.readRatesMidWithDate(
            rateCode = rateCode,
            tableCode = tableCode,
            startDate = today.minus(DatePeriod(days = TWO_WEEKS_IN_DAYS)),
            endDate = today,
        ).map { rates ->
            val currentMid = rates.last().mid
            rates.map {
                it.toRateMidWithDateUi(
                    currentMid = currentMid,
                    significantChangeThreshold = SIGNIFICANT_CHANGE_THRESHOLD,
                )
            }.sortedByDescending { it.effectiveDate }
        }
    }


    companion object {
        const val TWO_WEEKS_IN_DAYS = 14
        const val SIGNIFICANT_CHANGE_THRESHOLD = 0.1
    }
}
