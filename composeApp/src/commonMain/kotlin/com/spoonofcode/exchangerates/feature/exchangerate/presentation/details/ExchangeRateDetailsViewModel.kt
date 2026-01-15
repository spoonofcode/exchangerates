package com.spoonofcode.exchangerates.feature.exchangerate.presentation.details

import androidx.lifecycle.viewModelScope
import com.spoonofcode.exchangerates.core.ui.base.BaseViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.domain.usecase.GetExchangeRateUseCase
import kotlinx.coroutines.launch

internal class ExchangeRateDetailsViewModel(
    private val getExchangeRateUseCase: GetExchangeRateUseCase,
) : BaseViewModel<ExchangeRateDetailsViewState, ExchangeRateDetailsViewAction>(
    initialViewState = ExchangeRateDetailsViewState(),
) {

    override fun onAction(action: ExchangeRateDetailsViewAction) {
        when (action) {
            is ExchangeRateDetailsViewAction.InitView -> initView(
                rateCode = action.rateCode,
                tableCode = action.tableCode,
                currency = action.currency,
            )
        }
    }

    private fun initView(rateCode: String, tableCode: String, currency: String) {
        showLoadingView()
        viewModelScope.launch {
            getExchangeRateUseCase(rateCode = rateCode, tableCode = tableCode)
                .onSuccess {
                    showContentView {
                        copy(
                            ratesMidWithDate = it,
                            currency = currency,
                            rateCode = rateCode
                        )
                    }
                }.onFailure {
                    showErrorView()
                }
        }
    }
}