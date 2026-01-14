package com.spoonofcode.exchangerates.feature.login.data

import com.spoonofcode.exchangerates.feature.login.data.mappers.toLogin
import com.spoonofcode.exchangerates.feature.login.data.remote.RemoteLoginCodeDataSource
import com.spoonofcode.exchangerates.feature.login.domain.model.Login
import com.spoonofcode.exchangerates.feature.login.domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val remoteLoginCodeDataSource: RemoteLoginCodeDataSource,
) : LoginRepository {

    override suspend fun loginWithCode(email: String, loginCode: String): Result<Login> =
        remoteLoginCodeDataSource.create(
            email = email,
            loginCode = loginCode,
        ).map { response -> response.toLogin() }
}