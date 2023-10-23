package com.example.auth.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.auth.ui.AuthScreen
import com.example.auth.util.AuthUiEvent
import com.example.auth.vm.AuthViewModel

const val MAIN_NAVIGATION_AUTH = "main_navigation_auth"

fun NavController.navigateToAuth(navOptions: NavOptions? = null) {
    this.navigate(MAIN_NAVIGATION_AUTH, navOptions)
}

fun NavGraphBuilder.authNavigation() {
    composable(route = MAIN_NAVIGATION_AUTH) {
        val authViewModel: AuthViewModel = hiltViewModel()
        val loginState by authViewModel.loginState.collectAsStateWithLifecycle()
        AuthScreen(loginState = loginState) {
            when (it) {
                is AuthUiEvent.LoginWithEmail -> {
                    authViewModel.loginWithEmail(it.email, it.password)
                }

                is AuthUiEvent.LoginWithPhone -> {
                    authViewModel.loginWithPhone(it.phone)
                }

                is AuthUiEvent.LoginWithGoogle -> {
                    authViewModel.loginWithGoogle(it.activity)
                }
            }
        }
    }
}