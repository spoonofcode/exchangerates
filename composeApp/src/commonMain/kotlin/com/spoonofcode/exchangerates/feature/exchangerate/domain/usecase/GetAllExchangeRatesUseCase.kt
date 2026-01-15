package com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase

import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.Rate
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.ExchangeRatesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class GetAllExchangeRatesUseCase(
    private val exchangeRatesRepository: ExchangeRatesRepository,
) {
    suspend operator fun invoke(): Result<List<Rate>> = runCatching {
        coroutineScope {
            val tableADeferred = async { exchangeRatesRepository.readTableA() }
            val tableBDeferred = async { exchangeRatesRepository.readTableB() }

            val tableA = tableADeferred.await().getOrThrow()
            val tableB = tableBDeferred.await().getOrThrow()

            tableA + tableB
        }
    }
}
