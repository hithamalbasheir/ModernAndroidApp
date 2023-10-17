package com.hitham.modernandroidsample.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hitham.modernandroidsample.data.db.entities.Medicine
import com.hitham.modernandroidsample.data.repositrories.MedicineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicineViewModel @Inject constructor(
	private val medicineRepository: MedicineRepository,
) : ViewModel() {
	val allMedicines: Flow<List<Medicine>> = medicineRepository.getAllMedicines()
	
	init {
		refreshMedicines()
	}
	
	private val _username = MutableLiveData<String>()
	val username: LiveData<String> = _username
	
	fun getMedicineById(medicineId: Int): Flow<Medicine?> {
		return medicineRepository.getMedicineById(medicineId)
	}
	
	private fun refreshMedicines() {
		viewModelScope.launch {
			medicineRepository.refreshMedicines()
		}
	}
}
