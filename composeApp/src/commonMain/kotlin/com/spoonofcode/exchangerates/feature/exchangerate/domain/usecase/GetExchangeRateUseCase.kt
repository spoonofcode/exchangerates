package com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase

import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.TableOfRates
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import kotlinx.coroutines.async

class GetExchangeRateUseCase(
    private val tableOfRatesRepository: TableOfRatesRepository,
) {
    suspend operator fun invoke(
        email: String,
        code: String,
    ): Result<TableOfRates> {
        val tableAAsync = async { tableOfRatesRepository.readTableA() }
        val tableBAsync = async { tableOfRatesRepository.readTableB()}

        val tableA = tableAAsync.await()
        val tableB = tableBAsync.await()

        return TableOfRates()
    }
}