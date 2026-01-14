package com.spoonofcode.exchangerates.core.data.repository

import com.spoonofcode.exchangerates.core.data.mockdata.CurrencyMockData.CURRENCY_1
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock

internal fun currencyRepositoryMock() = mock<TableOfRatesRepository> {
    everySuspend { loginWithCode(any(), any()) } returns Result.success(CURRENCY_1)
}