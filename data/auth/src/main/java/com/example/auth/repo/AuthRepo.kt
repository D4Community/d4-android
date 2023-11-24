package com.example.auth.repo

import androidx.activity.ComponentActivity
import com.example.common.utils.ResponseState
import kotlinx.coroutines.flow.Flow

interface AuthRepo {
    suspend fun loginWithPhone(phoneNumber: String)
    suspend fun loginWithEmail(email: String, password: String)
    suspend fun loginWithGoogle(activity: ComponentActivity)
    suspend fun isAuthenticated(): Boolean
    suspend fun logout(): Flow<ResponseState<Boolean>>
}