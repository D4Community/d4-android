package com.example.datastore.model

sealed class ScreenCode(val code: Int) {
    object Auth : ScreenCode(0)
    object Home : ScreenCode(1)
}
