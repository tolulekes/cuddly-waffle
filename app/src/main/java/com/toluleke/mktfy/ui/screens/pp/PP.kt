package com.toluleke.mktfy.ui.screens.pp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun PP() {
    PPState()
}

@Composable
private fun PPState(
    viewModel: PPViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    PPContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun PPContent(
    viewState: PPViewState = PPViewState(),
    actioner: (PPAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun PPPreview() {
    MKTFYTheme {
        PPContent(viewState = PPViewState())
    }
}

