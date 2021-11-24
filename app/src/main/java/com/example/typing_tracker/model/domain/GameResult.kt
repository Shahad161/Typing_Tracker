package com.example.typing_tracker.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "GAME_RESULT_TABLE")
data class GameResult(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val keyStrokes: Int,
    val correctCharacters: Int,
    val wrongCharacters: Int,
    val wpm: Double,
    val accuracy: Double,
    val difficulty: String,
    val date: Date,
)
