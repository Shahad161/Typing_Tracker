package com.example.typing_tracker.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "CHARACTER_TABLE")
data class Character(
    @PrimaryKey(autoGenerate = true) val characterId: Int,
    val character: String,
    val speed: Double,
    val entryDate: Date,
)
