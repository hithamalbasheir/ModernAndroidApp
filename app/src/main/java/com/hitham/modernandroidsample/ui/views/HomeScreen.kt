package com.hitham.modernandroidsample.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.hitham.modernandroidsample.data.db.entities.Medicine
import com.hitham.modernandroidsample.ui.viewmodels.MedicineViewModel
import java.time.LocalDateTime

@Composable
fun HomeScreen(
	viewModel: MedicineViewModel,
	username: String,
	onDetailsRequested: (Int) -> Unit,
) {
	val medicines by viewModel.allMedicines.collectAsState(initial = emptyList())
	
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		Greeting(username)
		LazyColumn(
			modifier = Modifier.weight(1f),
			verticalArrangement = Arrangement.spacedBy(8.dp),
		) {
			items(medicines) { medicine ->
				MedicineCard(
					medicine = medicine,
					onDetailsRequested = onDetailsRequested,
				)
			}
		}
	}
}

@Composable
fun Greeting(username: String) {
	val currentHour = LocalDateTime.now().hour
	val greetingMessage = greetingMessage(currentHour)
	Text(
		modifier = Modifier.padding(24.dp), text = buildAnnotatedString {
			withStyle(MaterialTheme.typography.bodyMedium.toSpanStyle()) {
				append(greetingMessage)
			}
			append(" ")
			withStyle(
				MaterialTheme.typography.bodyLarge.toSpanStyle()
					.copy(color = MaterialTheme.colorScheme.primary),
			) {
				append(username)
			}
			
		}, style = MaterialTheme.typography.bodyLarge
	)
}

@Composable
fun greetingMessage(currentHour: Int): String {
	val greetingMessage = when {
		currentHour < 12 -> "Good Morning"
		currentHour < 18 -> "Good Afternoon"
		else -> "Good Evening"
	}
	return greetingMessage
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicineCard(medicine: Medicine, onDetailsRequested: (Int) -> Unit) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 24.dp),
		elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
		onClick = {
			onDetailsRequested(medicine.id)
		},
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.surface,
		),
	) {
		Column(
			modifier = Modifier.padding(16.dp)
		) {
			Text(text = medicine.name, style = MaterialTheme.typography.bodyLarge)
			Spacer(modifier = Modifier.height(8.dp))
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
			) {
				Text(
					text = "Dose ${medicine.dose}",
					style = MaterialTheme.typography.bodyMedium
				)
				Text(
					text = "Strength: ${medicine.strength}",
					style = MaterialTheme.typography.bodyMedium
				)
			}
		}
	}
}
