package com.example.auth.ui

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.auth.util.AuthUiEvent
import com.example.common.R
import com.example.common.utils.UiState
import io.appwrite.models.Account
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(loginState: UiState<Account>, onUiEvent: (AuthUiEvent) -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.logo_black),
            contentDescription = "D4 Community"
        )

        Column {
            var phone by rememberSaveable {
                mutableStateOf("")
            }
            TextField(
                value = phone,
                onValueChange = {
                    phone = it
                }
            )
            Button(
                onClick = {
                    scope.launch {
                        onUiEvent(AuthUiEvent.LoginWithPhone("+91234567890"))
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                Text("Phone")
            }

            Row(horizontalArrangement = Arrangement.Center) {
                IconButton(
                    onClick = {
                        scope.launch {
                            onUiEvent(AuthUiEvent.LoginWithEmail("email@example.com", "password"))
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "")
                }
                IconButton(
                    onClick = {
                        scope.launch {
                            onUiEvent(AuthUiEvent.LoginWithGoogle(context as ComponentActivity))
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                }
            }

        }
    }
}