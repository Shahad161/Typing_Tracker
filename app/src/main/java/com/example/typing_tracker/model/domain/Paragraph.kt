package com.example.typing_tracker.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.typing_tracker.util.Difficulty

@Entity(tableName = "PARAGRAPH_TABLE")
data class Paragraph(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val paragraph: String,
    val difficulty: Difficulty,
)
