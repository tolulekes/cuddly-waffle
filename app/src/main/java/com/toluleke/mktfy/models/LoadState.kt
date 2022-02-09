package com.toluleke.mktfy.models

sealed class LoadState {
    object None: LoadState()

    data class Loading(
        val progress: Int? = null
    ): LoadState()

    data class Success(
        val title: String?,
        val message: String? = null,
        val actionLabel: String = "Continue",
        val  action: () -> Unit
    ): LoadState()

    data class Error(
        val title: String?,
        val message: String?,
        val tryAgain: (() -> Unit)?,
        val cancel: () -> Unit
    ): LoadState()
}

