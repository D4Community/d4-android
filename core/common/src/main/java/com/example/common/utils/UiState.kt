package com.example.common.utils

import androidx.annotation.StringRes


sealed interface UiState<out T> {
    object Loading : UiState<Nothing>
    object Idle : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class ErrorMessage(@StringRes val resId: Int) : UiState<Nothing>
    data class ErrorRetry(@StringRes val resId: Int) : UiState<Nothing>
    object NoInternet : UiState<Nothing>
}