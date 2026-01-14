package com.spoonofcode.exchangerates.feature.exchangerate.data.remote

import com.spoonofcode.exchangerates.core.data.base.RemoteBaseDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.TableOfRatesResponse
import io.ktor.http.HttpMethod

class RemoteTableOfRatesDataSource() : RemoteBaseDataSource(
    collectionName = "/api/exchangerates/tables",
) {
    suspend fun readTableA(): Result<TableOfRatesResponse> = doRequest(
        urlPostfixPath = "A",
        method = HttpMethod.Get,
    )

    suspend fun readTableB(): Result<TableOfRatesResponse> = doRequest(
        urlPostfixPath = "B",
        method = HttpMethod.Get,
    )
}