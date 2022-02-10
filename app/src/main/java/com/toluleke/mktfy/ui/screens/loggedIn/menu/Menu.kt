package com.toluleke.mktfy.ui.screens.loggedIn.menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun Menu() {
    MenuState()
}

@Composable
private fun MenuState(
    viewModel: MenuViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    MenuContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun MenuContent(
    viewState: MenuViewState = MenuViewState(),
    actioner: (MenuAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun MenuPreview() {
    MKTFYTheme {
        MenuContent(viewState = MenuViewState())
    }
}

