package com.spoonofcode.exchangerates.core.dispatchers

import com.spoonofcode.exchangerates.core.data.base.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher

class StandardTestDispatcherProvider(
    private val testDispatcher: TestDispatcher
) : DispatcherProvider {
    override fun main(): CoroutineDispatcher = testDispatcher

    override fun io(): CoroutineDispatcher = testDispatcher

    override fun default(): CoroutineDispatcher = testDispatcher
}