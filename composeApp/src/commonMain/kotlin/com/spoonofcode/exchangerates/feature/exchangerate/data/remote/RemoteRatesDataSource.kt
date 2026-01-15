package com.spoonofcode.exchangerates.feature.exchangerate.data.remote

import com.spoonofcode.exchangerates.core.data.base.RemoteBaseDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.RatesMidWithDateResponse
import io.ktor.http.HttpMethod

class RemoteRatesDataSource() : RemoteBaseDataSource(
    collectionName = "api/exchangerates/rates",
) {

    suspend fun readRatesMidWithDate(
        rateCode: String,
        tableCode: String
    ): Result<RatesMidWithDateResponse> = doRequest(
        urlPostfixPath = "${tableCode}/${rateCode}/2012-01-01/2012-01-31",
        method = HttpMethod.Get,
    )
}