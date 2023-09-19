package com.example.auth.vm

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.repo.AuthRepo
import com.example.common.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.appwrite.models.Account
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel
@Inject constructor(
    private val authRepo: AuthRepo
) : ViewModel() {

    private val _loginState = MutableStateFlow<UiState<Account>>(UiState.Idle)
    val loginState = _loginState.asStateFlow()

    fun isAuthenticated() = viewModelScope.launch {
        authRepo.isAuthenticated()
    }

    fun loginWithEmail(email: String, password: String) = viewModelScope.launch {
        authRepo.loginWithEmail(email, password)
    }

    fun loginWithPhone(phoneNumber: String) = viewModelScope.launch {
        authRepo.loginWithPhone(phoneNumber)
    }

    fun loginWithGoogle(activity: ComponentActivity) = viewModelScope.launch {
        authRepo.loginWithGoogle(activity)
    }

}