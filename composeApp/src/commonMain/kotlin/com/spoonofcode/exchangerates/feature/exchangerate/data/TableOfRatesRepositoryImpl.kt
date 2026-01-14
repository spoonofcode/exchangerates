package com.spoonofcode.exchangerates.feature.exchangerate.data

import com.spoonofcode.exchangerates.feature.exchangerate.data.mappers.toTableOfRates
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.RemoteTableOfRatesDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.TableOfRates
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository

class TableOfRatesRepositoryImpl(
    private val remoteTableOfRatesDataSource: RemoteTableOfRatesDataSource,
) : TableOfRatesRepository {

    override suspend fun readTableA(): Result<TableOfRates> =
        remoteTableOfRatesDataSource.readTableA().map { response -> response.toTableOfRates() }

    override suspend fun readTableB(): Result<TableOfRates> =
        remoteTableOfRatesDataSource.readTableA().map { response -> response.toTableOfRates() }
}