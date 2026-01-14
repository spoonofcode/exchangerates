package com.spoonofcode.exchangerates.feature.login.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val jwtAccessToken: String,
    val jwtRefreshToken: String,
)