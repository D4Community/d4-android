package com.example.auth.vm

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.repo.AuthRepo
import com.example.common.utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel
@Inject constructor(
    private val authRepo: AuthRepo
) : ViewModel() {

    val userAccount = authRepo.userAccount

    fun loginWithEmail(email: String, password: String) = viewModelScope.launch {
        authRepo.loginWithEmail(email, password)
    }

    fun loginWithPhone(phoneNumber: String) = viewModelScope.launch {
        authRepo.loginWithPhone(phoneNumber)
    }

    fun loginWithGoogle(activity: ComponentActivity) = viewModelScope.launch {
        authRepo.loginWithGoogle(activity)
    }

    fun logout() = viewModelScope.launch {
        authRepo.logout().collect {
            if (it is ResponseState.Success) {
                userAccount.value = null
            }
        }
    }

}