package com.spoonofcode.exchangerates.core.data.repository

import com.spoonofcode.exchangerates.core.data.mockdata.RatesMidWithDateMockData.RATES_MID_WITH_DATE
import com.spoonofcode.exchangerates.core.data.mockdata.RatesMockData.TABLE_A
import com.spoonofcode.exchangerates.core.data.mockdata.RatesMockData.TABLE_B
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock

internal fun tableOfRatesRepositoryMock() = mock<TableOfRatesRepository> {
    everySuspend { readTableA() } returns Result.success(TABLE_A)
    everySuspend { readTableB() } returns Result.success(TABLE_B)
    everySuspend { readRatesMidWithDate(any(), any(), any(), any()) } returns Result.success(
        RATES_MID_WITH_DATE
    )
}