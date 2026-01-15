package com.spoonofcode.exchangerates.feature.exchangerate.presentation.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.spoonofcode.exchangerates.core.ui.base.BaseScreen
import com.spoonofcode.exchangerates.core.ui.compose.Paddings.spaceBetweenListElements
import com.spoonofcode.exchangerates.core.ui.compose.Spacers
import com.spoonofcode.exchangerates.core.ui.compose.Texts
import com.spoonofcode.exchangerates.core.ui.ext.koinViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.presentation.model.RateMidWithDateUi
import com.spoonofcode.exchangerates.resources.Res
import com.spoonofcode.exchangerates.resources.exchange_rate
import com.spoonofcode.exchangerates.resources.exchange_rates
import org.jetbrains.compose.ui.tooling.preview.Preview

internal class ExchangeRateDetailsScreen(
    override val verticalScrollEnable: Boolean = false,
    private val rateCode: String,
    private val tableCode: String,
) :
    BaseScreen<ExchangeRateDetailsViewModel, ExchangeRateDetailsViewState, ExchangeRateDetailsViewAction>() {

    override fun provideTopAppBarTitle() = Res.string.exchange_rate

    override fun provideInitAction(onAction: (ExchangeRateDetailsViewAction) -> Unit): () -> Unit =
        {
            onAction(
                ExchangeRateDetailsViewAction.InitView(
                    rateCode = rateCode,
                    tableCode = tableCode
                )
            )
        }

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
        item: RateMidWithDateUi,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Texts.BL(
                text = item.mid.toString(),
                color = if (item.isSignificantChange) Color.Red else Color.Unspecified,
            )
            Spacers.Weight1(this)
            Texts.BL(item.effectiveDate)
        }
    }
}

// region previews
@Preview
@Composable
private fun ExchangeRateDetailsScreenContentPreview() {
    ExchangeRateDetailsScreen(
        rateCode = "EUR",
        tableCode = "A"
    ).PreviewContent(
        ExchangeRateDetailsViewState()
    )
}
// endregion