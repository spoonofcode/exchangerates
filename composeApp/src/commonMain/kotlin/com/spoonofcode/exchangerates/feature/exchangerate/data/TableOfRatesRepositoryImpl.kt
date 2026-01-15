package com.spoonofcode.exchangerates.feature.exchangerate.data

import com.spoonofcode.exchangerates.feature.exchangerate.data.mappers.toRate
import com.spoonofcode.exchangerates.feature.exchangerate.data.mappers.toRateMidWithDate
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.RemoteRatesDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.RemoteTableOfRatesDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.Rate
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.RateMidWithDate
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository

class TableOfRatesRepositoryImpl(
    private val remoteTableOfRatesDataSource: RemoteTableOfRatesDataSource,
    private val remoteRatesDataSource: RemoteRatesDataSource,
) : TableOfRatesRepository {

    override suspend fun readTableA(): Result<List<Rate>> =
        remoteTableOfRatesDataSource.readTableA()
            .map { response -> response.first().rates.map { it.toRate() } }

    override suspend fun readTableB(): Result<List<Rate>> =
        remoteTableOfRatesDataSource.readTableB()
            .map { response -> response.first().rates.map { it.toRate() } }

    override suspend fun readRatesMidWithDate(
        rateCode: String,
        tableCode: String
    ): Result<List<RateMidWithDate>> =
        remoteRatesDataSource.readRatesMidWithDate(rateCode = rateCode, tableCode = tableCode)
            .map { response -> response.rates.map { it.toRateMidWithDate() } }
}