package com.example.auth.util

import androidx.activity.ComponentActivity

sealed interface AuthUiEvent {
    data class LoginWithEmail(val email: String, val password: String) : AuthUiEvent
    data class LoginWithPhone(val phone: String) : AuthUiEvent
    data class LoginWithGoogle(val activity: ComponentActivity) : AuthUiEvent
}