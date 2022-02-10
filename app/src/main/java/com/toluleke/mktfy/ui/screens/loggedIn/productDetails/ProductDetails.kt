package com.toluleke.mktfy.ui.screens.loggedIn.productDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toluleke.mktfy.ui.theme.MKTFYTheme

@Composable
fun ProductDetails() {
    ProductDetailsState()
}

@Composable
private fun ProductDetailsState(
    viewModel: ProductDetailsViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()
    ProductDetailsContent(
        viewState = viewState,
        actioner = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@Composable
private fun ProductDetailsContent(
    viewState: ProductDetailsViewState = ProductDetailsViewState(),
    actioner: (ProductDetailsAction) -> Unit = {}
) {
}

@Preview
@Composable
private fun ProductDetailsPreview() {
    MKTFYTheme {
        ProductDetailsContent(viewState = ProductDetailsViewState())
    }
}

