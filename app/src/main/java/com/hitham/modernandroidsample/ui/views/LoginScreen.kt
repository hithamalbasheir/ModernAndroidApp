package com.hitham.modernandroidsample.ui.views

import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hitham.modernandroidsample.ui.viewmodels.LoginViewModel
import com.hitham.modernandroidsample.util.CredentialsValidator

@Composable
fun LoginScreen(
	viewModel: LoginViewModel = hiltViewModel(),
	onUserLogged: (username: String) -> Unit,
) {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		var username by remember { mutableStateOf("") }
		var password by remember { mutableStateOf("") }
		val context = LocalContext.current  // Get the current context
		val credentialsValidator = CredentialsValidator()
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(16.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			TextField(
				modifier = Modifier.fillMaxWidth(),
				value = username,
				onValueChange = { newValue -> username = newValue },
				label = { Text(text = ("Username or Email")) },
				singleLine = true,
				maxLines = 1,
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
			)
			Spacer(modifier = Modifier.height(16.dp))
			TextField(
				modifier = Modifier.fillMaxWidth(),
				value = password,
				onValueChange = { newValue -> password = newValue },
				label = { Text("Password") },
				maxLines = 1,
				visualTransformation = PasswordVisualTransformation(),
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
			)
			Spacer(modifier = Modifier.height(16.dp))
			Button(
				modifier = Modifier.fillMaxWidth()
					.padding(4.dp),
				onClick = {
					val isUsernameValid = credentialsValidator.validateUsername(username)
					val isPasswordValid = credentialsValidator.validatePassword(password)
					if (isUsernameValid && isPasswordValid) {
						viewModel.onLoginClicked(
							username = username,
							onLoginSuccess = {
								onUserLogged(username)
							},
						)
					} else {
						Toast.makeText(
							context,
							"Username must be at least 8 characters long, and password must contain an uppercase letter, a lowercase letter, and a number.",
							Toast.LENGTH_LONG
						).show()
					}
				},
			) {
				Text(text = "Login")
			}
		}
	}
}
