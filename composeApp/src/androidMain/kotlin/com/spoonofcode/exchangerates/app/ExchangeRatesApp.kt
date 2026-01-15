package com.spoonofcode.exchangerates.app

import android.app.Application

class ExchangeRatesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}