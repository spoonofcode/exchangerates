package com.spoonofcode.exchangerates.core.data.repository

import com.spoonofcode.exchangerates.core.data.mockdata.RatesMockData.CURRENCY_1
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock

internal fun tableOfRatesRepositoryMock() = mock<TableOfRatesRepository> {
    everySuspend { readTableA() } returns Result.success(CURRENCY_1)
    everySuspend { readTableA() } returns Result.success(CURRENCY_1)
    everySuspend { readRatesMidWithDate(any(), any(), any(), any()) } returns Result.success(
        CURRENCY_1
    )
}