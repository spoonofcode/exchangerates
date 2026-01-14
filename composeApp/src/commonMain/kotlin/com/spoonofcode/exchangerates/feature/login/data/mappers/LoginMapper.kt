package com.spoonofcode.exchangerates.feature.login.data.mappers

import com.spoonofcode.exchangerates.feature.login.data.remote.model.LoginResponse
import com.spoonofcode.exchangerates.feature.login.domain.model.Login

fun LoginResponse.toLogin(): Login {
    return Login(
        jwtAccessToken = jwtAccessToken,
        jwtRefreshToken = jwtRefreshToken
    )
}