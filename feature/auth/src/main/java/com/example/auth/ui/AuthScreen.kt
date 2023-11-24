package com.example.auth.ui

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.auth.util.AuthUiEvent
import com.example.common.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(onUiEvent: (AuthUiEvent) -> Unit) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.logo_black),
            contentDescription = "D4 Community"
        )
        var phone by rememberSaveable {
            mutableStateOf("+91")
        }
        TextField(
            value = phone,
            onValueChange = {
                phone = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Button(
            onClick = {
                onUiEvent(AuthUiEvent.LoginWithPhone(phone))
            }
        ) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = "")
            Text("Phone")
        }

        var email by rememberSaveable {
            mutableStateOf("")
        }
        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        var password by rememberSaveable {
            mutableStateOf("")
        }
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        Button(
            onClick = {
                onUiEvent(AuthUiEvent.LoginWithEmail(email, password))
            }
        ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "")
        }

        Spacer(modifier = Modifier.padding(16.dp))

        IconButton(
            onClick = {
                onUiEvent(AuthUiEvent.LoginWithGoogle(context as ComponentActivity))
            }
        ) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
        }
    }
}