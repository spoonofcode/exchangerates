package com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase

import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.TableOfRates
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope

class GetAllExchangeRatesUseCase(
    private val tableOfRatesRepository: TableOfRatesRepository,
) {
    suspend operator fun invoke(
        email: String,
        code: String,
    ): Result<TableOfRates> =
        supervisorScope {
            val tableADeferred = async {
                runCatching {
                    tableOfRatesRepository.readTableA()
                }
            }
            val tableBDeferred = async {
                runCatching {
                    tableOfRatesRepository.readTableB()
                }
            }

            val tableA = tableADeferred.await()
            val tableB = tableBDeferred.await()

            return Result.success(TableOfRates())
        }
}