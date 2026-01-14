package com.spoonofcode.exchangerates.core.network

data class NetworkConfigImpl(
    override val baseUrl: String = "https://api.nbp.pl/",
) : NetworkConfig