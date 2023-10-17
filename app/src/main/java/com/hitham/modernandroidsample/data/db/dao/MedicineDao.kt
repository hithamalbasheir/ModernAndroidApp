package com.hitham.modernandroidsample.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hitham.modernandroidsample.data.db.entities.Medicine
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicine")
    fun getAllMedicines(): Flow<List<Medicine>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(medicines: List<Medicine>)
    @Query("SELECT * FROM medicine WHERE id = :medicineId")
    fun getMedicineById(medicineId: Int): Flow<Medicine?>
}