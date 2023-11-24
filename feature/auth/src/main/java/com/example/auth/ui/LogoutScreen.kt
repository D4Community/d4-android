package com.example.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.auth.util.AuthUiEvent
import com.example.common.utils.UiState
import io.appwrite.models.Account

@Composable
fun LogoutScreen(loginState: UiState<Account>, onUiEvent: (AuthUiEvent) -> Unit) {
    if (loginState is UiState.Success) {
        Column {
            Text(modifier = Modifier.padding(16.dp), text = loginState.data.name)
            Text(modifier = Modifier.padding(16.dp), text = loginState.data.email)
            Text(modifier = Modifier.padding(16.dp), text = loginState.data.phone)

            Button(onClick = { onUiEvent(AuthUiEvent.Logout) }) {
                Text(text = "Logout")
            }
        }
    }
}