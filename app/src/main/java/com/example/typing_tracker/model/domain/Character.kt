package com.example.typing_tracker.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CHARACTER_TABLE")
data class Character(
    @PrimaryKey(autoGenerate = true) val characterId: Long,
    val character: String,
)
