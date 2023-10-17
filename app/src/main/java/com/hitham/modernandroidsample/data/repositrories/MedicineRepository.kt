package com.hitham.modernandroidsample.data.repositrories

import com.hitham.modernandroidsample.data.db.dao.MedicineDao
import com.hitham.modernandroidsample.data.db.entities.Medicine
import com.hitham.modernandroidsample.data.network.ApiService
import com.hitham.modernandroidsample.data.network.toDatabaseModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MedicineRepository @Inject constructor(
    private val apiService: ApiService,
    private val medicineDao: MedicineDao
) {
    fun getAllMedicines(): Flow<List<Medicine>> {
        return medicineDao.getAllMedicines()
    }

    suspend fun refreshMedicines() {
        try {
            apiService.getMedicineData().let { response ->
                if (response.isSuccessful) {
                    val medicineResponse = response.body()
                    medicineResponse?.let {
                        val medicines = it.toDatabaseModel()
                        medicineDao.insertAll(medicines)
                    }
                }
            }
        } catch (t: Throwable){
            // Fucked up!
        }
    }

    fun getMedicineById(medicineId: Int): Flow<Medicine?> {
        return medicineDao.getMedicineById(medicineId)
    }
}
