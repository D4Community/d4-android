package com.example.auth.navigation

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.auth.vm.AuthViewModel
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
        val authViewModel: AuthViewModel = hiltViewModel()

        Row {
            Button(
                onClick = {
                    scope.launch {
                        authViewModel.loginWithEmail("email@example.com", "password")
                    }
                }
            ) {
                Text("E-mail")
            }
            Button(
                onClick = {
                    scope.launch {
                        authViewModel.loginWithPhone("+91234567890")
                    }
                }
            ) {
                Text("Phone")
            }
            Button(
                onClick = {
                    scope.launch {
                        authViewModel.loginWithGoogle(context as ComponentActivity)
                    }
                }
            ) {
                Text("Google")
            }
        }
    }
}