package com.spoonofcode.exchangerates.feature.login.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginCodeRequest(
    val email: String,
    @SerialName("login_code")
    val loginCode: String,
)