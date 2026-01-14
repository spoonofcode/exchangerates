package com.spoonofcode.exchangerates.feature.exchangerate.data.mappers

import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.TableOfRatesResponse
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.TableOfRates

fun TableOfRatesResponse.toTableOfRates(): TableOfRates {
    return TableOfRates(
        jwtAccessToken = jwtAccessToken,
        jwtRefreshToken = jwtRefreshToken
    )
}