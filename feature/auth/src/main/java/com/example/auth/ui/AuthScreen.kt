package com.example.auth.ui

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.auth.util.AuthUiEvent
import com.example.common.R

@Composable
fun AuthScreen(onUiEvent: (AuthUiEvent) -> Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
//            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.logo_black),
            contentDescription = "D4 Community"
        )
//        var phone by rememberSaveable {
//            mutableStateOf("+91")
//        }
//        TextField(
//            value = phone,
//            onValueChange = {
//                phone = it
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Number
//            )
//        )
//        Button(
//            onClick = {
//                onUiEvent(AuthUiEvent.LoginWithPhone(phone))
//            }
//        ) {
//            Icon(imageVector = Icons.Default.Phone, contentDescription = "")
//            Text("Phone")
//        }
//
//        var email by rememberSaveable {
//            mutableStateOf("")
//        }
//        TextField(
//            value = email,
//            onValueChange = {
//                email = it
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Email
//            )
//        )
//        var password by rememberSaveable {
//            mutableStateOf("")
//        }
//        TextField(
//            value = password,
//            onValueChange = {
//                password = it
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Password
//            )
//        )
//        Button(
//            onClick = {
//                onUiEvent(AuthUiEvent.LoginWithEmail(email, password))
//            }
//        ) {
//            Icon(imageVector = Icons.Default.Email, contentDescription = "")
//        }
//
//        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = {
                onUiEvent(AuthUiEvent.LoginWithGoogle(context as ComponentActivity))
            }
        ) {
            Text("Sign in with Google")
        }
    }
}