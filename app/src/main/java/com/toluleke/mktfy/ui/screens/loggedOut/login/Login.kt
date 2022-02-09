package com.toluleke.mktfy.ui.screens.loggedOut.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun Login() {
    LoginState()
}

@Composable
private fun LoginState(
    viewModel: LoginViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    LoginContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun LoginContent(
    viewState: LoginViewState = LoginViewState(),
    actioner: (LoginAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun LoginPreview() {
    MKTFYTheme {
        LoginContent(viewState = LoginViewState())
    }
}

