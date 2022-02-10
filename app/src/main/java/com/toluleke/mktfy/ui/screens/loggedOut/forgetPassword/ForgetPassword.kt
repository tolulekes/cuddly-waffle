package com.toluleke.mktfy.ui.screens.loggedOut.forgetPassword

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun ForgetPassword() {
    ForgetPasswordState()
}

@Composable
private fun ForgetPasswordState(
    viewModel: ForgetPasswordViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    ForgetPasswordContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun ForgetPasswordContent(
    viewState: ForgetPasswordViewState = ForgetPasswordViewState(),
    actioner: (ForgetPasswordAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun ForgetPasswordPreview() {
    MKTFYTheme {
        ForgetPasswordContent(viewState = ForgetPasswordViewState())
    }
}

