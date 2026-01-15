package com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spoonofcode.exchangerates.core.ui.base.BaseScreen
import com.spoonofcode.exchangerates.core.ui.compose.Paddings.spaceBetweenListElements
import com.spoonofcode.exchangerates.core.ui.compose.Texts
import com.spoonofcode.exchangerates.core.ui.ext.koinViewModel
import com.spoonofcode.exchangerates.feature.exchangerate.domain.model.Rate
import com.spoonofcode.exchangerates.resources.Res
import com.spoonofcode.exchangerates.resources.exchange_rates
import org.jetbrains.compose.ui.tooling.preview.Preview

internal class ExchnageRateOverviewScreen(
    override val verticalScrollEnable: Boolean = false,
    override val backNavigationEnable: Boolean = false,
) : BaseScreen<ExchangeRateOverviewViewModel, ExchangeRateOverviewViewState, ExchangeRateOverviewViewAction>() {

    override fun provideTopAppBarTitle() = Res.string.exchange_rates

    override fun provideInitAction(onAction: (ExchangeRateOverviewViewAction) -> Unit): () -> Unit =
        { onAction(ExchangeRateOverviewViewAction.InitView) }

    @Composable
    override fun provideViewModel() = koinViewModel<ExchangeRateOverviewViewModel>()

    @Composable
    override fun provideContent(
        viewState: ExchangeRateOverviewViewState,
        onAction: (ExchangeRateOverviewViewAction) -> Unit,
    ): @Composable (ColumnScope.() -> Unit) {
        return {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(spaceBetweenListElements)
            ) {
                items(viewState.rates) { rate ->
                    RateItem(
                        item = rate,
                        onClick = {
                            onAction(
                                ExchangeRateOverviewViewAction.SelectRate(
                                    rateCode = rate.code,
                                    tableCode = "a"
                                )
                            )
                        }
                    )
                }
            }
        }
    }

    @Composable
    fun RateItem(
        item: Rate,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
    ) {
        ElevatedCard(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
        ) {
            Texts.BL(item.code)
            Texts.BL(item.currency)
            Texts.BL(item.mid.toString())
        }
    }
}

// region previews
@Preview
@Composable
private fun ExchangeRateDetailsScreenContentPreview() {
    ExchnageRateOverviewScreen().PreviewContent(
        ExchangeRateOverviewViewState()
    )
}
// endregion