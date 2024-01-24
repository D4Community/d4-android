package com.example.auth.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.auth.ui.AuthScreen
import com.example.auth.ui.LogoutScreen
import com.example.auth.util.AuthUiEvent
import com.example.auth.vm.AuthViewModel

const val AUTH_GRAPH_ROUTE = "auth_graph_route"
const val LOGIN_SCREEN = "auth_sign_in_screen"

fun NavController.navigateToAuth(navOptions: NavOptions? = null) {
    this.navigate(AUTH_GRAPH_ROUTE, navOptions)
}

fun NavGraphBuilder.authNavigation(navController: NavHostController) {
    navigation(
        route = AUTH_GRAPH_ROUTE,
        startDestination = LOGIN_SCREEN
    ) {
        composable(route = LOGIN_SCREEN) {
            val authViewModel: AuthViewModel = hiltViewModel()
            val userAccount by authViewModel.userAccount.collectAsStateWithLifecycle()

            if (userAccount == null) {
                AuthScreen { authUiEvent ->
                    when (authUiEvent) {
                        is AuthUiEvent.LoginWithEmail -> {
                            authViewModel.loginWithEmail(authUiEvent.email, authUiEvent.password)
                        }

                        is AuthUiEvent.LoginWithPhone -> {
                            authViewModel.loginWithPhone(authUiEvent.phone)
                        }

                        is AuthUiEvent.LoginWithGoogle -> {
                            authViewModel.loginWithGoogle(authUiEvent.activity)
                        }

                        is AuthUiEvent.Logout -> {
                            authViewModel.logout()
                        }
                    }
                }
            } else {
                LogoutScreen(userAccount = userAccount!!) {
                    when (it) {
                        is AuthUiEvent.Logout -> authViewModel.logout()
                        else -> {}
                    }
                }
            }

        }
    }

}