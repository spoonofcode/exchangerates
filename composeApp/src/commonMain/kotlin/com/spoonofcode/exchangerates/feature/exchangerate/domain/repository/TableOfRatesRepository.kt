package com.spoonofcode.exchangerates.feature.exchangerate.domain.repository

import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.TableOfRates

interface TableOfRatesRepository {
    suspend fun readTableA(): Result<TableOfRates>
    suspend fun readTableB(): Result<TableOfRates>
}