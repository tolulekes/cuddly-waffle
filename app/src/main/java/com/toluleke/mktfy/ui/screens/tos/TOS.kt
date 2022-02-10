package com.toluleke.mktfy.ui.screens.tos

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun TOS() {
    TOSState()
}

@Composable
private fun TOSState(
    viewModel: TOSViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    TOSContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun TOSContent(
    viewState: TOSViewState = TOSViewState(),
    actioner: (TOSAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun TOSPreview() {
    MKTFYTheme {
        TOSContent(viewState = TOSViewState())
    }
}

