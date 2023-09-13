package com.example.auth.navigation

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import io.appwrite.Client
import io.appwrite.ID
import io.appwrite.services.Account
import kotlinx.coroutines.launch

const val MAIN_NAVIGATION_AUTH = "main_navigation_auth"
const val TAG = "AUTH"

fun NavController.navigateToAuth(navOptions: NavOptions? = null) {
    this.navigate(MAIN_NAVIGATION_AUTH, navOptions)
}

fun NavGraphBuilder.authNavigation() {
    composable(route = MAIN_NAVIGATION_AUTH) {
        val context = LocalContext.current
        val scope = rememberCoroutineScope()
        val client = remember {
            Client(context)
                .setEndpoint("https://cloud.appwrite.io/v1")
                .setProject("64f95cfebf8d4953f7a6")
        }
        val account = remember {
            Account(client)
        }

        Row {
            Button(
                onClick = {
                    scope.launch {
                        val user = account.create(
                            userId = ID.unique(),
                            email = "email@example.com",
                            password = "password"
                        )
                        Log.d(TAG, "authNavigation: $user")
                    }
                }
            ) {
                Text("E-mail")
            }
            Button(
                onClick = {
                    scope.launch {
                        val token = account.createPhoneSession(
                            userId = ID.unique(),
                            phone = "+911234567890"
                        )
                        Log.d(TAG, "authNavigation: $token")
                    }
                }
            ) {
                Text("Phone")
            }
        }
    }
}