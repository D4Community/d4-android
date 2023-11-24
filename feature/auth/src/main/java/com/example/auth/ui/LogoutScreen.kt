package com.example.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.auth.util.AuthUiEvent
import io.appwrite.models.Account

@Composable
fun LogoutScreen(userAccount: Account, onUiEvent: (AuthUiEvent) -> Unit) {
    Column {
        Text(modifier = Modifier.padding(16.dp), text = userAccount.name)
        Text(modifier = Modifier.padding(16.dp), text = userAccount.email)
        Text(modifier = Modifier.padding(16.dp), text = userAccount.phone)

        Button(onClick = { onUiEvent(AuthUiEvent.Logout) }) {
            Text(text = "Logout")
        }
    }
}