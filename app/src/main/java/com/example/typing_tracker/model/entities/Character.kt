package com.example.typing_tracker.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "CHARACTER_TABLE")
data class Character(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val character: String,
    val isCorrect: Boolean,
    val speed: Double,
    val entryDate: Date,
)
