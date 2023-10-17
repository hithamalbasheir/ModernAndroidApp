package com.hitham.modernandroidsample.di

import android.content.Context
import androidx.room.Room
import com.hitham.modernandroidsample.data.db.AppDatabase
import com.hitham.modernandroidsample.data.db.dao.MedicineDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMedicineDao(database: AppDatabase): MedicineDao {
        return database.medicineDao()
    }
}