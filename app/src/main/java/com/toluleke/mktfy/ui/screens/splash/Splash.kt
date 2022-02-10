package com.toluleke.mktfy.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun Splash() {
    SplashState()
}

@Composable
private fun SplashState(
    viewModel: SplashViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    SplashContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun SplashContent(
    viewState: SplashViewState = SplashViewState(),
    actioner: (SplashAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun SplashPreview() {
    MKTFYTheme {
        SplashContent(viewState = SplashViewState())
    }
}

