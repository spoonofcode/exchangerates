package com.spoonofcode.exchangerates.feature.exchangerate.data.remote

import com.spoonofcode.exchangerates.core.data.base.RemoteBaseDataSource
import com.spoonofcode.exchangerates.feature.exchangerate.data.remote.model.RatesMidWithDateResponse
import io.ktor.http.HttpMethod

class RemoteRatesDataSource() : RemoteBaseDataSource(
    collectionName = "api/exchangerates/rates",
) {

    suspend fun readRatesMidWithDate(
        rateCode: String,
        tableCode: String,
        startDate: String = "2012-01-01",
        endDate: String = "2012-01-31",
    ): Result<RatesMidWithDateResponse> = doRequest(
        urlPostfixPath = "$tableCode/$rateCode/$startDate/$endDate",
        method = HttpMethod.Get,
    )
}