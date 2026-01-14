package com.spoonofcode.exchangerates.core.data.repository

import com.spoonofcode.exchangerates.core.data.mockdata.LoginMockData.LOGIN_1
import com.spoonofcode.exchangerates.feature.login.domain.repository.LoginRepository
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock

internal fun loginRepositoryMock() = mock<LoginRepository> {
    everySuspend { loginWithCode(any(), any()) } returns Result.success(LOGIN_1)
    everySuspend { loginWithGoogle(any()) } returns Result.success(LOGIN_1)
    everySuspend { requestCode(any(), any()) } returns Result.success(Unit)
}