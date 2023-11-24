package com.example.auth.repo

import androidx.activity.ComponentActivity
import com.example.common.R
import com.example.common.utils.ResponseState
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import io.appwrite.ID
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Account
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepoImpl
@Inject constructor(
    private val account: Account,
    private val googleSignInClient: GoogleSignInClient
) : AuthRepo {
    override suspend fun isAuthenticated(): Boolean {
        return try {
            account.get()
            true
        } catch (e: AppwriteException) {
            false
        }
    }

    override suspend fun logout(): Flow<ResponseState<Boolean>> =
        withContext(NonCancellable) {
            callbackFlow {
                try {
                    account.deleteSessions()
                    googleSignInClient.signOut().addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            trySend(ResponseState.Success(true))
                        } else {
                            trySend(ResponseState.ErrorMessage(R.string.sign_out_failed))
                        }
                    }
                } catch (e: Exception) {
                    trySend(ResponseState.ErrorMessage(R.string.sign_out_failed))
                }
                awaitClose { close() }
            }
        }

    override suspend fun loginWithEmail(email: String, password: String) {
        account.create(
            userId = ID.unique(),
            email = email,
            password = password
        )
    }

    override suspend fun loginWithPhone(phoneNumber: String) {
        account.createPhoneSession(
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