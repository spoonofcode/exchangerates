package com.spoonofcode.exchangerates.feature.exchangerate.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.spoonofcode.exchangerates.core.ui.base.BaseScreen
import com.spoonofcode.exchangerates.core.ui.compose.Paddings.spaceBetweenListElements
import com.spoonofcode.exchangerates.core.ui.compose.Texts
import com.spoonofcode.exchangerates.core.ui.ext.koinViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.RateMidWithDate
import com.spoonofcode.exchangerates.resources.Res
import com.spoonofcode.exchangerates.resources.exchange_rates
import org.jetbrains.compose.ui.tooling.preview.Preview

internal class ExchangeRateDetailsScreen(
    override val verticalScrollEnable: Boolean = false,
    private val rateCode: String,
) :
    BaseScreen<ExchangeRateDetailsViewModel, ExchangeRateDetailsViewState, ExchangeRateDetailsViewAction>() {

    override fun provideTopAppBarTitle() = Res.string.exchange_rates

    override fun provideInitAction(onAction: (ExchangeRateDetailsViewAction) -> Unit): () -> Unit =
        { onAction(ExchangeRateDetailsViewAction.InitView(rateCode = rateCode)) }

    @Composable
    override fun provideViewModel() = koinViewModel<ExchangeRateDetailsViewModel>()

    @Composable
    override fun provideContent(
        viewState: ExchangeRateDetailsViewState,
        onAction: (ExchangeRateDetailsViewAction) -> Unit,
    ): @Composable (ColumnScope.() -> Unit) {
        return {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(spaceBetweenListElements)
            ) {
                items(viewState.ratesMidWithDate) { rateMidWithDate ->
                    RateMidWithDateItem(
                        item = rateMidWithDate,
                    )
                }
            }

        }
    }

    @Composable
    fun RateMidWithDateItem(
        item: RateMidWithDate,
    ) {
        println("BARTEK $item")
        Texts.BL(item.mid.toString())
        Texts.BL(item.effectiveDate)
    }
}

// region previews
@Preview
@Composable
private fun ExchangeRateDetailsScreenContentPreview() {
    ExchangeRateDetailsScreen(
        rateCode = "EUR"
    ).PreviewContent(
        ExchangeRateDetailsViewState()
    )
}
// endregion