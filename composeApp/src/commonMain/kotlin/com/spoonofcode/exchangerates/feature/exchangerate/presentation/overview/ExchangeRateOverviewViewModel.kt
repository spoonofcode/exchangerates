package com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview

import androidx.lifecycle.viewModelScope
import com.spoonofcode.exchangerates.core.ui.base.BaseViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase.GetAllExchangeRatesUseCase
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.details.ExchangeRateDetailsScreen
import kotlinx.coroutines.launch

internal class ExchangeRateOverviewViewModel(
    private val getAllExchangeRatesUseCase: GetAllExchangeRatesUseCase,
) : BaseViewModel<ExchangeRateOverviewViewState, ExchangeRateOverviewViewAction>(
    initialViewState = ExchangeRateOverviewViewState(),
) {

    override fun onAction(action: ExchangeRateOverviewViewAction) {
        when (action) {
            ExchangeRateOverviewViewAction.InitView -> initView()
            is ExchangeRateOverviewViewAction.SelectRate -> selectRate(action.rateCode)
        }
    }

    private fun initView() {
        showLoadingView()
        viewModelScope.launch {
            getAllExchangeRatesUseCase()
                .onSuccess {
                    showContentView { copy(rates = it) }
                }.onFailure {
                    showErrorSnackbar(it)
                }
        }
    }

    private fun selectRate(rateCode: String) {
        viewModelScope.launch {
            viewModelNavigator.push(
                ExchangeRateDetailsScreen(
                    rateCode = rateCode
                )
            )
        }
    }
}