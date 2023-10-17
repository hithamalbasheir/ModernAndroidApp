package com.hitham.modernandroidsample.data.network

import com.hitham.modernandroidsample.data.db.entities.Medicine


fun MedicineResponse.toDatabaseModel(): List<Medicine> {
	val medicines = mutableListOf<Medicine>()
	this.problems.forEach { problem ->
		problem.Diabetes.forEach { diabete ->
			diabete.medications.forEach { medication ->
				medication.medicationsClasses.forEach { medicationsClass ->
					medicationsClass.className.forEach { className ->
						className.associatedDrug.forEach {
							it.name?.let { name ->
								medicines.add(
									Medicine(
										name = name,
										dose = it.dose ?: "",
										strength = it.strength ?: "",
									)
								)
							}
						}
						className.secondAssociatedDrug.forEach {
							it.name?.let { name ->
								medicines.add(
									Medicine(
										name = name,
										dose = it.dose ?: "",
										strength = it.strength ?: "",
									)
								)
							}
						}
					}
					medicationsClass.className2.forEach { className ->
						className.associatedDrug.forEach {
							it.name?.let { name ->
								medicines.add(
									Medicine(
										name = name,
										dose = it.dose ?: "",
										strength = it.strength ?: "",
									)
								)
							}
						}
						className.secondAssociatedDrug.forEach {
							it.name?.let { name ->
								medicines.add(
									Medicine(
										name = name,
										dose = it.dose ?: "",
										strength = it.strength ?: "",
									)
								)
							}
						}
					}
				}
			}
		}
	}
	return medicines
}
