package com.spoonofcode.exchangerates.feature.login.domain.usecase

import com.spoonofcode.exchangerates.feature.login.domain.repository.LoginRepository

class LoginCodeUseCase(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(
        email: String,
        code: String,
    ): Result<Unit> = loginRepository.loginWithCode(
        email = email,
        loginCode = code,
    ).map { loginResponse ->
//        sessionManager.saveSessionUserId(userId = loginResponse.userId)
//        sessionManager.saveSessionAccessToken(token = loginResponse.jwtAccessToken)
//        sessionManager.saveSessionRefreshToken(token = loginResponse.jwtRefreshToken)
//        sessionManager.enableAllNotifications()
    }
}