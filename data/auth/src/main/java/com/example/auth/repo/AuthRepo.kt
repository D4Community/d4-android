package com.example.auth.repo

import androidx.activity.ComponentActivity
import com.example.common.utils.ResponseState
import io.appwrite.models.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface AuthRepo {
    val userAccount: MutableStateFlow<Account?>
    suspend fun loginWithPhone(phoneNumber: String)
    suspend fun loginWithEmail(email: String, password: String)
    suspend fun loginWithGoogle(activity: ComponentActivity)
    suspend fun logout(): Flow<ResponseState<Boolean>>
}