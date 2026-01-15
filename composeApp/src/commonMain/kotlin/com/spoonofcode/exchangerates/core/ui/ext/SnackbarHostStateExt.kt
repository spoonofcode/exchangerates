package com.spoonofcode.exchangerates.core.ui.ext

import androidx.compose.material3.SnackbarHostState
import com.spoonofcode.exchangerates.core.ui.compose.CustomSnackbarVisuals
import com.spoonofcode.exchangerates.core.ui.snackbar.SnackbarEvent

suspend fun SnackbarHostState.showSnackbar(
    snackbarEvent: SnackbarEvent,
) {
    showSnackbar(
        CustomSnackbarVisuals(
            message = snackbarEvent.message,
            actionLabel = snackbarEvent.actionLabel,
            duration = snackbarEvent.duration,
            type = snackbarEvent.type,
        )
    )
}