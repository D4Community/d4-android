package com.example.auth.repo

import androidx.activity.ComponentActivity
import com.example.common.R
import com.example.common.di.IODispatcher
import com.example.common.utils.ResponseState
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import io.appwrite.ID
import io.appwrite.services.Account
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepoImpl
@Inject constructor(
    private val account: Account,
    private val googleSignInClient: GoogleSignInClient,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthRepo {

    override val userAccount = MutableStateFlow<io.appwrite.models.Account?>(null)

    override suspend fun logout(): Flow<ResponseState<Boolean>> =
        withContext(NonCancellable) {
            callbackFlow {
                try {
                    account.deleteSession("current")
                    googleSignInClient.signOut().addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            trySend(ResponseState.Success(true))
                            userAccount.value = null
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

    override suspend fun loginWithEmail(email: String, password: String) =
        withContext(coroutineDispatcher) {
            userAccount.value = account.create(
                userId = ID.unique(),
                email = email,
                password = password
            )
        }

    override suspend fun loginWithPhone(phoneNumber: String) = withContext(coroutineDispatcher) {
        val token = account.createPhoneSession(
            userId = ID.unique(),
            phone = phoneNumber
        )
    }

    override suspend fun loginWithGoogle(activity: ComponentActivity) =
        withContext(coroutineDispatcher) {
            account.createOAuth2Session(
                activity = activity,
                provider = "google"
            )
            userAccount.value = account.get()
        }

}