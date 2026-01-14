package com.spoonofcode.exchangerates.feature.login.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginGoogleRequest(
    @SerialName("id_token")
    val googleUserToken: String
)