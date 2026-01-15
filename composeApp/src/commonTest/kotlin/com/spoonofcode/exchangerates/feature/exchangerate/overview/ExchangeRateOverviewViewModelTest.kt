package com.spoonofcode.exchangerates.feature.exchangerate.overview

import app.cash.turbine.test
import com.spoonofcode.exchangerates.core.data.mockdata.RatesMockData
import com.spoonofcode.exchangerates.core.ui.base.BaseViewModelTest
import com.spoonofcode.exchangerates.core.ui.base.ScreenState
import com.spoonofcode.exchangerates.core.ui.base.ViewState
import com.spoonofcode.exchangerates.feature.exchangerate.di.exchangeRateTestModule
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.ExchangeRatesRepository
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.details.ExchangeRateDetailsScreen
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewViewAction
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewViewState
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.ofType
import dev.mokkery.verifySuspend
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class ExchangeRateOverviewViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: ExchangeRateOverviewViewModel
    private lateinit var exchangeRatesRepository: ExchangeRatesRepository

    @BeforeTest
    override fun setup() {
        modules = arrayOf(exchangeRateTestModule)
        super.setup()
        exchangeRatesRepository = getKoin().get()
        viewModel = getSut()
    }

    @Test
    fun `initial state is default`() = runTest {
        viewModel.viewState.test {
            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(),
                    screenState = ScreenState.LOADING,
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `init view`() = runTest {
        viewModel.viewState.test {
            skipItems(1)

            viewModel.onAction(ExchangeRateOverviewViewAction.InitView)

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(
                        rates = RatesMockData.TABLE_A + RatesMockData.TABLE_B,
                    ),
                    screenState = ScreenState.CONTENT,
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `init view error`() = runTest {
        everySuspend { exchangeRatesRepository.readTableA() } returns
                Result.failure(Exception("not found"))

        viewModel.viewState.test {
            skipItems(1)

            viewModel.onAction(ExchangeRateOverviewViewAction.InitView)

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(),
                    screenState = ScreenState.ERROR,
                ),
                actual = awaitItem()
            )
        }

        verifySuspend {
            exchangeRatesRepository.readTableA()
        }
    }

    @Test
    fun `select rate`() = runTest {
        viewModel.onAction(
            ExchangeRateOverviewViewAction.SelectRate(
                rateCode = "USD",
                tableCode = "a",
                currency = "dolar amerykański"
            )
        )
        advanceUntilIdle()

        verifySuspend { viewModelNavigator.push(ofType<ExchangeRateDetailsScreen>()) }
    }
}
