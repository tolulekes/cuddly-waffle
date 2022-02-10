package com.toluleke.mktfy.ui.screens.faq

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun FAQ() {
    FAQState()
}

@Composable
private fun FAQState(
    viewModel: FAQViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    FAQContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun FAQContent(
    viewState: FAQViewState = FAQViewState(),
    actioner: (FAQAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun FAQPreview() {
    MKTFYTheme {
        FAQContent(viewState = FAQViewState())
    }
}

