package com.spoonofcode.exchangerates

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform