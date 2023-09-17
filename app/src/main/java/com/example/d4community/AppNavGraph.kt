package com.example.d4community

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.auth.navigation.MAIN_NAVIGATION_AUTH
import com.example.auth.navigation.authNavigation

@Composable
fun AppNavGraph() {
    val context = LocalContext.current

    val navController = rememberNavController()

    val startDestination = MAIN_NAVIGATION_AUTH

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authNavigation(context as ComponentActivity)
    }
}