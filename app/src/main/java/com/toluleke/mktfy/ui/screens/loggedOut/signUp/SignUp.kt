package com.toluleke.mktfy.ui.screens.loggedOut.signUp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun SignUp() {
    SignUpState()
}

@Composable
private fun SignUpState(
    viewModel: SignUpViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    SignUpContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun SignUpContent(
    viewState: SignUpViewState = SignUpViewState(),
    actioner: (SignUpAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun SignUpPreview() {
    MKTFYTheme {
        SignUpContent(viewState = SignUpViewState())
    }
}

