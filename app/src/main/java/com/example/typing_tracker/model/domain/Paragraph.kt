package com.example.typing_tracker.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PARAGRAPH_TABLE")
data class Paragraph(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val paragraph: String,
    val difficulty: String,
)
