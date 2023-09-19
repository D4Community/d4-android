package com.example.auth.repo

import androidx.activity.ComponentActivity
import io.appwrite.ID
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Account
import javax.inject.Inject

class AuthRepoImpl
@Inject constructor(
    private val account: Account
) : AuthRepo {
    override suspend fun isAuthenticated(): Boolean {
        return try {
            account.get()
            true
        } catch (e: AppwriteException) {
            false
        }
    }

    override suspend fun loginWithEmail(email: String, password: String) {
        val user = account.create(
            userId = ID.unique(),
            email = email,
            password = password
        )
    }

    override suspend fun loginWithPhone(phoneNumber: String) {
        val token = account.createPhoneSession(
            userId = ID.unique(),
            phone = phoneNumber
        )
    }

    override suspend fun loginWithGoogle(activity: ComponentActivity) {
        account.createOAuth2Session(
            activity = activity,
            provider = "google"
        )
    }

}