package com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase

import com.spoonofcode.exchangerates.core.utils.LocalDateTimeUtils
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.RateMidWithDate
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.minus

class GetExchangeRateUseCase(
    private val tableOfRatesRepository: TableOfRatesRepository,
) {
    suspend operator fun invoke(
        rateCode: String,
        tableCode: String
    ): Result<List<RateMidWithDate>> {
        val today = LocalDateTimeUtils.now().date
        return tableOfRatesRepository.readRatesMidWithDate(
            rateCode = rateCode,
            tableCode = tableCode,
            startDate = today.minus(DatePeriod(days = TWO_WEEKS_IN_DAYS)),
            endDate = today,
        )
    }

    companion object {
        const val TWO_WEEKS_IN_DAYS = 14
    }
}
