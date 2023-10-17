package com.hitham.modernandroidsample.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicine(
    val name: String,
    val dose: String,
    val strength: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)
