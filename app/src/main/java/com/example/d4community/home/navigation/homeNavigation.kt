package com.example.d4community.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

const val HOME_GRAPH_ROUTE = "home_graph_route"
const val HOME_SCREEN = "home_screen"

fun NavGraphBuilder.homeNavigation(navController: NavController) {
    navigation(
        route = HOME_GRAPH_ROUTE,
        startDestination = HOME_SCREEN
    ) {
        composable(HOME_SCREEN) {

        }
    }
}