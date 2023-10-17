package com.hitham.modernandroidsample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hitham.modernandroidsample.data.db.dao.MedicineDao
import com.hitham.modernandroidsample.data.db.entities.Medicine

@Database(entities = [Medicine::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao
}