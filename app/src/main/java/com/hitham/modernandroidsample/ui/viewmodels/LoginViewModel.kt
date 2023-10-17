package com.hitham.modernandroidsample.ui.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
	fun onLoginClicked(username: String, onLoginSuccess: () -> Unit) {
		if (username.isNotEmpty()) {
			onLoginSuccess()
		}
	}
}
