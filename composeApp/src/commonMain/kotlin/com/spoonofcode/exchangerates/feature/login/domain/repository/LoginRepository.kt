package com.spoonofcode.exchangerates.feature.login.domain.repository

import com.spoonofcode.exchangerates.feature.login.domain.model.Login

interface LoginRepository {
    suspend fun loginWithCode(email: String, loginCode: String): Result<Login>
}