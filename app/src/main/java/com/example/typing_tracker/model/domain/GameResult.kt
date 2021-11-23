package com.example.typing_tracker.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.typing_tracker.util.Difficulty
import java.util.*

@Entity(tableName = "GAME_RESULT_TABLE")
data class GameResult(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val keyStrokes: Int,
    val correctCharacters: Int,
    val wrongCharacters: Int,
    val wpm: Double,
    val accuracy: Double,
    val difficulty: Difficulty,
    val date: Date,
)
