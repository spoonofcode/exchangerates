package com.spoonofcode.exchangerates.feature.exchangerate.overview

import app.cash.turbine.test
import com.spoonofcode.exchangerates.app.MainHostScreen
import com.spoonofcode.exchangerates.core.BaseViewModelTest
import com.spoonofcode.exchangerates.core.ext.containsTypes
import com.spoonofcode.exchangerates.core.ui.ScreenState
import com.spoonofcode.exchangerates.core.ui.ViewState
import com.spoonofcode.exchangerates.feature.exchangerate.di.loginTestModule
import com.spoonofcode.exchangerates.feature.exchangerate.domain.repository.TableOfRatesRepository
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewViewAction
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview.ExchangeRateOverviewViewState
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.logincode.LoginCodeScreen
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.matcher.ofType
import dev.mokkery.verify.VerifyMode.Companion.exactly
import dev.mokkery.verifySuspend
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class CurrencyOverviewViewModelTest : BaseViewModelTest() {

    private lateinit var viewModel: ExchangeRateOverviewViewModel
    private lateinit var tableOfRatesRepository: TableOfRatesRepository

    @BeforeTest
    override fun setup() {
        modules = arrayOf(loginTestModule)
        super.setup()
        tableOfRatesRepository = getKoin().get()
        viewModel = getSut()
    }

    @Test
    fun `initial state is default`() = runTest {
        viewModel.viewState.test {
            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(),
                    screenState = ScreenState.CONTENT,
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `change email`() = runTest {
        val email = "john@doe.com"
        viewModel.viewState.test {
            skipItems(1)

            viewModel.onAction(ExchangeRateOverviewViewAction.ChangeEmail(email))

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(
                        email = email,
                    ),
                    screenState = ScreenState.CONTENT,
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `sign in with Google success`() = runTest {
        val token = "google-id-token"
        viewModel.viewState.test {
            skipItems(1)

            viewModel.onAction(ExchangeRateOverviewViewAction.SignInWithGoogle(token))

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(),
                    screenState = ScreenState.LOADING,
                ),
                actual = awaitItem()
            )
        }

        verifySuspend {
            tableOfRatesRepository.loginWithGoogle(any())
        }
        verifySuspend {
            viewModelNavigator.replaceAll(containsTypes(MainHostScreen::class))
        }
    }


    @Test
    fun `sign in with Google error`() = runTest {
        val token = "google-id-token"
        everySuspend {
            tableOfRatesRepository.loginWithGoogle(any())
        } returns Result.failure(Exception("error"))

        viewModel.viewState.test {
            skipItems(1)

            viewModel.onAction(ExchangeRateOverviewViewAction.SignInWithGoogle(token))

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(),
                    screenState = ScreenState.LOADING,
                ),
                actual = awaitItem()
            )

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(),
                    screenState = ScreenState.CONTENT,
                ),
                actual = awaitItem()
            )
        }

        verifySuspend {
            tableOfRatesRepository.loginWithGoogle(any())
        }

        verifySuspend(mode = exactly(0)) {
            viewModelNavigator.replaceAll(any())
        }
    }

    @Test
    fun `sign in with code success`() = runTest {
        val email = "john@doe.com"
        viewModel.onAction(ExchangeRateOverviewViewAction.ChangeEmail(email))

        viewModel.viewState.test {
            skipItems(1)

            viewModel.onAction(ExchangeRateOverviewViewAction.SignInWithCode)

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(email = email),
                    screenState = ScreenState.LOADING,
                ),
                actual = awaitItem()
            )
        }
        advanceUntilIdle()

        verifySuspend {
            tableOfRatesRepository.requestCode(email = email, recaptchaToken = any())
        }
        verifySuspend {
            viewModelNavigator.push(ofType<LoginCodeScreen>())
        }
    }

    @Test
    fun `sign in with code error`() = runTest {
        val email = "john@doe.com"
        viewModel.onAction(ExchangeRateOverviewViewAction.ChangeEmail(email))

        everySuspend {
            tableOfRatesRepository.requestCode(any(), any())
        } returns Result.failure(Exception("error"))

        viewModel.viewState.test {
            skipItems(1)

            viewModel.onAction(ExchangeRateOverviewViewAction.SignInWithCode)

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(email = email),
                    screenState = ScreenState.LOADING,
                ),
                actual = awaitItem()
            )

            assertEquals(
                expected = ViewState(
                    data = ExchangeRateOverviewViewState(email = email),
                    screenState = ScreenState.CONTENT,
                ),
                actual = awaitItem()
            )
        }

        verifySuspend {
            tableOfRatesRepository.requestCode(any(), any())
        }

        verifySuspend(mode = exactly(0)) {
            viewModelNavigator.push(ofType<LoginCodeScreen>())
        }
    }
}
