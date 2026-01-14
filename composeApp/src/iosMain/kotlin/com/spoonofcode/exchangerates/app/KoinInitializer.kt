package com.spoonofcode.exchangerates.app

import com.spoonofcode.exchangerates.app.di.appModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(
                appModule,
            )
        }
    }
}