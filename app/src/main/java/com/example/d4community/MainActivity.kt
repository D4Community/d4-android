package com.example.d4community

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.auth.navigation.MAIN_NAVIGATION_AUTH
import com.example.auth.navigation.authNavigation
import com.example.d4community.ui.theme.D4CommunityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D4CommunityTheme {
                val navController = rememberNavController()
                NavHost(
                    navController,
                    MAIN_NAVIGATION_AUTH
                ) {
                    authNavigation()
                }
            }
        }
    }
}

