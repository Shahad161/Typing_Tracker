package com.example.typing_tracker.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PROPERTY_TABLE")
data class CharacterProperty(
    @PrimaryKey(autoGenerate = true)
    val propertyId: Long,
    val characterId: Long,
    val speed: Double,
)