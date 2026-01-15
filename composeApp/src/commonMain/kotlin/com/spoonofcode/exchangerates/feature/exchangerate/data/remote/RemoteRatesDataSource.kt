package com.spoonofcode.exchangerates.feature.exchangerate.data.remote

import com.spoonofcode.exchangerates.core.data.base.RemoteBaseDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.RatesMidWithDateResponse
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.TableOfRatesResponse
import io.ktor.http.HttpMethod

class RemoteRatesDataSource() : RemoteBaseDataSource(
    collectionName = "api/exchangerates/rates",
) {

    suspend fun readRatesMidWithDate(): Result<RatesMidWithDateResponse> = doRequest(
        urlPostfixPath = "a/gbp/2012-01-01/2012-01-31",
        method = HttpMethod.Get,
    )
}