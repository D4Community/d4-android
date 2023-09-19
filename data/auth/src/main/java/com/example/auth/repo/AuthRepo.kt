package com.example.auth.repo

import androidx.activity.ComponentActivity

interface AuthRepo {
    suspend fun loginWithPhone(phoneNumber: String)
    suspend fun loginWithEmail(email: String, password: String)
    suspend fun loginWithGoogle(activity: ComponentActivity)
    suspend fun isAuthenticated(): Boolean
}