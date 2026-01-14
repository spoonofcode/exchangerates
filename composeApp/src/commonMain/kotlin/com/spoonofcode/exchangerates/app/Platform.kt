package com.spoonofcode.exchangerates.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform