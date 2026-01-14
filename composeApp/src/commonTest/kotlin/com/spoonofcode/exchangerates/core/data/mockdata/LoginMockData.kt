package com.spoonofcode.exchangerates.core.data.mockdata

import com.spoonofcode.exchangerates.feature.login.domain.model.Login

object LoginMockData {
    val LOGIN_1 = Login(
        jwtAccessToken = "jwtAccessToken 1",
        jwtRefreshToken = "jwtRefreshToken 1",
    )
}