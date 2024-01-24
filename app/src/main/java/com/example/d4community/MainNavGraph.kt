package com.example.d4community

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.auth.navigation.authNavigation
import com.example.d4community.home.navigation.homeNavigation

@Composable
fun AppNavGraph(startDestination: String) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authNavigation(navController)
        homeNavigation(navController)
    }
}