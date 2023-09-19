package com.example.common.utils


sealed interface UiState<out T> {
    object Loading : UiState<Nothing>
    object Idle : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>

    data class Error(val resId: Int) : UiState<Nothing>
}