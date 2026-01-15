package com.spoonofcode.exchangerates.feature.exchangerate.details

import app.cash.turbine.test
import com.spoonofcode.exchangerates.core.data.mockdata.RatesMidWithDateMockData
import com.spoonofcode.exchangerates.core.ui.base.BaseViewModelTest
import com.spoonofcode.exchangerates.core.ui.base.ScreenState
import com.spoonofcode.exchangerates.core.ui.base.ViewState
import com.spoonofcode.exchangerates.feature.exchangerate.di.exchangeRateTestModule
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase.GetExchangeRateUseCase.Companion.SIGNIFICANT_CHANGE_THRESHOLD
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.details.ExchangeRateDetailsViewAction
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.details.ExchangeRateDetailsViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.details.ExchangeRateDetailsViewState
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.mappers.toRateMidWithDateUi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class ExchangeRateDetailsViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: ExchangeRateDetailsViewModel
    private lateinit var tableOfRatesRepository: TableOfRatesRepository

    @BeforeTest
    override fun setup() {
        modules = arrayOf(exchangeRateTestModule)
        super.setup()
        tableOfRatesRepository = getKoin().get()
        viewModel = getSut()
    }

    @Test
    fun `initial state is default`() = runTest {
        viewModel.viewState.test {
            assertEquals(
                expected = ViewState(
                    data = ExchangeRateDetailsViewState(),
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

            viewModel.onAction(
                ExchangeRateDetailsViewAction.InitView(
                    rateCode = "USD",
                    tableCode = "a"
                )
            )

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateDetailsViewState(
                        ratesMidWithDate = RatesMidWithDateMockData.RATES_MID_WITH_DATE.map {
                            it.toRateMidWithDateUi(
                                currentMid = RatesMidWithDateMockData.RATES_MID_WITH_DATE.last().mid,
                                significantChangeThreshold = SIGNIFICANT_CHANGE_THRESHOLD
                            )
                        },
                    ),
                    screenState = ScreenState.CONTENT,
                ),
                actual = awaitItem()
            )
        }
    }

}
