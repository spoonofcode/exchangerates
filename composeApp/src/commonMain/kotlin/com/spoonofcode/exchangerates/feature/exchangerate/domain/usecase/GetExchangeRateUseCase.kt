package com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase

import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.RateMidWithDate
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository

class GetExchangeRateUseCase(
    private val tableOfRatesRepository: TableOfRatesRepository,
) {
    suspend operator fun invoke(): Result<List<RateMidWithDate>> = tableOfRatesRepository.readRatesMidWithDate()
}