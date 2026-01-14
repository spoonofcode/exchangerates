package com.spoonofcode.exchangerates.feature.login.data.remote

import com.spoonofcode.exchangerates.core.data.base.RemoteBaseDataSource
import com.spoonofcode.exchangerates.feature.login.data.remote.model.LoginCodeRequest
import com.spoonofcode.exchangerates.feature.login.data.remote.model.LoginResponse
import io.ktor.http.HttpMethod

class RemoteLoginCodeDataSource() : RemoteBaseDataSource(
    collectionName = "api/login/code",
) {
    suspend fun create(
        email: String,
        loginCode: String,
    ): Result<LoginResponse> = doRequest<LoginResponse>(
        method = HttpMethod.Post,
        requestBody = LoginCodeRequest(
            email = email,
            loginCode = loginCode,
        ),
    )
}