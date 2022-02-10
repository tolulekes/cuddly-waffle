package com.toluleke.mktfy.ui.screens.loggedIn.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun Home() {
    HomeState()
}

@Composable
private fun HomeState(
    viewModel: HomeViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    HomeContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun HomeContent(
    viewState: HomeViewState = HomeViewState(),
    actioner: (HomeAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun HomePreview() {
    MKTFYTheme {
        HomeContent(viewState = HomeViewState())
    }
}

