package com.example.d4community

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.auth.navigation.AUTH_GRAPH_ROUTE
import com.example.d4community.ui.theme.D4CommunityTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            D4CommunityTheme {
                AppNavGraph(AUTH_GRAPH_ROUTE)
            }
        }
    }
}

