package com.spoonofcode.exchangerates.feature.exchangerate.presentation.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spoonofcode.exchangerates.core.ui.base.BaseScreen
import com.spoonofcode.exchangerates.core.ui.compose.Paddings
import com.spoonofcode.exchangerates.core.ui.compose.Spacers
import com.spoonofcode.exchangerates.core.ui.compose.Texts
import com.spoonofcode.exchangerates.core.ui.ext.koinViewModel
import com.spoonofcode.exchangerates.resources.Res
import com.spoonofcode.exchangerates.resources.let_s_get_started
import com.spoonofcode.exchangerates.resources.or
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

internal class ExchnageRateOverviewScreen(
    override val backNavigationEnable: Boolean = false,
) : BaseScreen<ExchangeRateOverviewViewModel, ExchangeRateOverviewViewState, ExchangeRateOverviewViewAction>() {

    @Composable
    override fun provideViewModel() = koinViewModel<ExchangeRateOverviewViewModel>()

    @Composable
    override fun provideContent(
        viewState: ExchangeRateOverviewViewState,
        onAction: (ExchangeRateOverviewViewAction) -> Unit,
    ): @Composable (ColumnScope.() -> Unit) {
        return {
            Column(
                modifier = Modifier.fillMaxSize().padding(
                    top = Paddings.screenPadding,
                ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacers.VerticalBetweenFields()
                Texts.HL(stringResource(resource = Res.string.let_s_get_started))
            }

            Spacers.VerticalBetweenFields()

            Spacers.VerticalBetweenFields()

            LabeledDivider()

            Spacers.VerticalBetweenFields()
        }
    }

    @Composable
    fun LabeledDivider(
        text: String = stringResource(resource = Res.string.or),
        modifier: Modifier = Modifier,
        lineColor: Color = MaterialTheme.colorScheme.outlineVariant,
        textColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
        thickness: Dp = 1.dp,
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = thickness,
                color = lineColor
            )

            Text(
                text = text,
                modifier = Modifier.padding(vertical = 2.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = textColor
            )

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = thickness,
                color = lineColor
            )
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