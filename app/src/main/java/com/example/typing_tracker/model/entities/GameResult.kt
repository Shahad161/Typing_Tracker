package com.example.typing_tracker.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.typing_tracker.util.Difficulty
import java.util.*

@Entity(tableName = "GAME_RESULT_TABLE")
data class GameResult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val keyStrokes: Int,
    val correctCharacters: Int,
    val wrongCharacters: Int,
    val wpm: Double,
    val accuracy: Double,
    var difficulty: Difficulty,
    val date: Date,
)
