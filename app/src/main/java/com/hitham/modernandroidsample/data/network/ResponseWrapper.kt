package com.hitham.modernandroidsample.data.network

import com.google.gson.annotations.SerializedName

data class MedicineResponse(
	@SerializedName("problems") val problems: List<Problems> = arrayListOf()
)

data class Problems(
	@SerializedName("Diabetes") val Diabetes: List<Diabetes> = arrayListOf(),
	@SerializedName("Asthma") val Asthma: List<Asthma> = arrayListOf()
)

data class Diabetes(
	@SerializedName("medications") val medications: List<Medications> = arrayListOf(),
	@SerializedName("labs") val labs: List<Labs> = arrayListOf()
)

data class Medications(
	@SerializedName("medicationsClasses") val medicationsClasses: List<MedicationsClasses> = arrayListOf()
)

data class Labs(
	@SerializedName("missing_field") val missingField: String? = null
)

data class Asthma(
	val id: String,
)

data class MedicationsClasses(
	@SerializedName("className") val className: List<ClassName> = arrayListOf(),
	@SerializedName("className2") val className2: List<ClassName> = arrayListOf()
)

data class ClassName(
	@SerializedName("associatedDrug") val associatedDrug: List<AssociatedDrug> = arrayListOf(),
	@SerializedName("associatedDrug#2") val secondAssociatedDrug: List<AssociatedDrug> = arrayListOf()
)

data class AssociatedDrug(
	@SerializedName("name") val name: String? = null,
	@SerializedName("dose") val dose: String? = null,
	@SerializedName("strength") val strength: String? = null
)
