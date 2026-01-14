package com.spoonofcode.exchangerates.feature.login.presentation.login

import androidx.lifecycle.viewModelScope
import com.spoonofcode.exchangerates.core.ui.base.BaseViewModel
import com.spoonofcode.exchangerates.core.ui.base.ScreenState
import com.spoonofcode.exchangerates.feature.login.domain.usecase.LoginCodeUseCase
import kotlinx.coroutines.launch

internal class LoginViewModel(
    private val loginCodeUseCase: LoginCodeUseCase,
) : BaseViewModel<LoginViewState, LoginViewAction>(
    initialViewState = LoginViewState(),
    initialScreenState = ScreenState.CONTENT,
) {

    override fun onAction(action: LoginViewAction) {
        when (action) {
            is LoginViewAction.ChangeEmail -> changeEmail(action.email)
            LoginViewAction.SignInWithCode -> signInWithCode()
            is LoginViewAction.SignInWithGoogle -> signInWithGoogle(action.googleIdToken)
        }
    }

    private fun changeEmail(email: String) {
        updateState {
            copy(email = email)
        }
    }

    private fun signInWithCode() {
        viewModelScope.launch {
            showLoadingView()
//            loginRequestCodeUseCase(
//                email = currentState().email,
//            ).onSuccess {
//                viewModelNavigator.push(LoginCodeScreen(email = currentState().email))
//            }.onFailure {
//                showErrorSnackbar(it)
//            }
        }
    }

    private fun signInWithGoogle(googleIdToken: String) {
        viewModelScope.launch {
            showLoadingView()
//            loginGoogleUseCase(googleIdToken)
//                .onSuccess {
//                    viewModelNavigator.replaceAll(listOf(MainHostScreen()))
//                }.onFailure {
//                    showErrorSnackbar(it)
//                }
        }
    }
}