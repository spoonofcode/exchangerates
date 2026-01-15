package com.spoonofcode.exchangerates.feature.exchangerate.data.remote

import com.spoonofcode.exchangerates.core.data.base.RemoteBaseDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.TableOfRatesResponse
import io.ktor.http.HttpMethod

class RemoteTableOfRatesDataSource() : RemoteBaseDataSource(
    collectionName = "api/exchangerates/tables",
) {
    suspend fun readTableA(): Result<List<TableOfRatesResponse>> = doRequest(
        urlPostfixPath = "a",
        method = HttpMethod.Get,
    )

    suspend fun readTableB(): Result<List<TableOfRatesResponse>> = doRequest(
        urlPostfixPath = "b",
        method = HttpMethod.Get,
    )
}