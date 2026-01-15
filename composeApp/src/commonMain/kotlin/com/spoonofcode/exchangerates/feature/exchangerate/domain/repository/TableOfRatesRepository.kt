package com.spoonofcode.exchangerates.feature.exchangerate.domain.repository

import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.Rate
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.RateMidWithDate

interface TableOfRatesRepository {
    suspend fun readTableA(): Result<List<Rate>>
    suspend fun readTableB(): Result<List<Rate>>
    suspend fun readRatesMidWithDate(
        rateCode: String,
        tableCode: String
    ): Result<List<RateMidWithDate>>
}