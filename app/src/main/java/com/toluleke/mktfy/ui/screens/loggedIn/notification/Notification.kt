package com.toluleke.mktfy.ui.screens.loggedIn.notification

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun Notification() {
    NotificationState()
}

@Composable
private fun NotificationState(
    viewModel: NotificationViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    NotificationContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun NotificationContent(
    viewState: NotificationViewState = NotificationViewState(),
    actioner: (NotificationAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun NotificationPreview() {
    MKTFYTheme {
        NotificationContent(viewState = NotificationViewState())
    }
}

