package com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase

import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.Rate
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class GetAllExchangeRatesUseCase(
    private val tableOfRatesRepository: TableOfRatesRepository,
) {
    suspend operator fun invoke(): Result<List<Rate>> = runCatching {
        coroutineScope {
            val tableADeferred = async { tableOfRatesRepository.readTableA() }
            val tableBDeferred = async { tableOfRatesRepository.readTableB() }

            val tableA = tableADeferred.await().getOrThrow()
            val tableB = tableBDeferred.await().getOrThrow()

            tableA + tableB
        }
    }
}
