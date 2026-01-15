package com.spoonofcode.exchangerates.feature.exchangerate.domain.model

data class Rate(
    val currency: String,
    val code: String,
    val mid: Double,
)