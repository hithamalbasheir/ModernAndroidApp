package com.hitham.modernandroidsample.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hitham.modernandroidsample.ui.viewmodels.MedicineViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicineDetailScreen(
	medicineId: Int,
	viewModel: MedicineViewModel = hiltViewModel(),
	onBack: () -> Unit,
) {
	val medicine by viewModel.getMedicineById(medicineId)
		.collectAsState(initial = null)
	
	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text(text = medicine?.name ?: "Medicine Detail") },
				navigationIcon = {
					IconButton(onClick = { onBack() }) {
						Icon(Icons.Default.ArrowBack, contentDescription = "Go Back")
					}
				},
			)
		},
	) { innerPadding ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(innerPadding)
				.padding(24.dp),
			verticalArrangement = Arrangement.spacedBy(12.dp),
		) {
			medicine?.let {
				Text(
					text = "Name: ${it.name}",
					style = MaterialTheme.typography.bodyLarge
				)
				Text(text = "Dose: ${it.dose}")
				Text(text = "Strength: ${it.strength}")
			}
		}
	}
}
