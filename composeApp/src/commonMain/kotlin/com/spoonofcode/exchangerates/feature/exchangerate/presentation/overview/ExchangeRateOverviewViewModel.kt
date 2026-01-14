package com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview

import androidx.lifecycle.viewModelScope
import com.spoonofcode.exchangerates.core.ui.base.BaseViewModel
import com.spoonofcode.exchangerates.core.ui.base.ScreenState
import com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase.GetAllExchangeRatesUseCase
import kotlinx.coroutines.launch

internal class ExchangeRateOverviewViewModel(
    private val getAllExchangeRatesUseCase: GetAllExchangeRatesUseCase,
) : BaseViewModel<ExchangeRateOverviewViewState, ExchangeRateOverviewViewAction>(
    initialViewState = ExchangeRateOverviewViewState(),
    initialScreenState = ScreenState.CONTENT,
) {

    override fun onAction(action: ExchangeRateOverviewViewAction) {
        when (action) {
            ExchangeRateOverviewViewAction.InitView -> initView()
        }
    }

    private fun initView() {
        showLoadingView()
        viewModelScope.launch {
//            loginRequestCodeUseCase(
//                email = currentState().email,
//            ).onSuccess {
//                viewModelNavigator.push(LoginCodeScreen(email = currentState().email))
//            }.onFailure {
//                showErrorSnackbar(it)
//            }
        }
    }
}