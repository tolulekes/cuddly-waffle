package com.toluleke.mktfy.ui.screens.loggedIn.resetPassword

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun ResetPassword() {
    ResetPasswordState()
}

@Composable
private fun ResetPasswordState(
    viewModel: ResetPasswordViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    ResetPasswordContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun ResetPasswordContent(
    viewState: ResetPasswordViewState = ResetPasswordViewState(),
    actioner: (ResetPasswordAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun ResetPasswordPreview() {
    MKTFYTheme {
        ResetPasswordContent(viewState = ResetPasswordViewState())
    }
}

