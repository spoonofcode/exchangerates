package com.spoonofcode.exchangerates.feature.login.presentation.login

import com.spoonofcode.exchangerates.core.ui.base.BaseViewAction

internal sealed interface LoginViewAction : BaseViewAction {
    data class ChangeEmail(val email: String) : LoginViewAction
    data object SignInWithCode : LoginViewAction
    data class SignInWithGoogle(val googleIdToken: String) : LoginViewAction
}