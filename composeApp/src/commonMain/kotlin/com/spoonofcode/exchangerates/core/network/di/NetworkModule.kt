package com.spoonofcode.exchangerates.core.network.di

import com.spoonofcode.exchangerates.core.network.NetworkConfig
import com.spoonofcode.exchangerates.core.network.NetworkConfigImpl
import com.spoonofcode.exchangerates.core.network.NetworkManager
import com.spoonofcode.exchangerates.core.network.NetworkManagerImpl
import dev.jordond.connectivity.Connectivity
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule: Module = module {
    single {
        Connectivity {
            autoStart = true
        }
    }
    single { NetworkConfigImpl() } bind NetworkConfig::class
    single { NetworkManagerImpl(get()) } bind NetworkManager::class

    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        encodeDefaults = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
}