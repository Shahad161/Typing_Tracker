package com.example.typing_tracker.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.typing_tracker.model.entities.*
import com.example.typing_tracker.util.Difficulty
import io.reactivex.rxjava3.core.*

@Dao
interface TypingDao {

    @Query("SELECT * FROM GAME_RESULT_TABLE ORDER BY date DESC")
    fun getAllGamesResults() : Single<List<GameResult>>

    @Query("SELECT * FROM GAME_RESULT_TABLE ORDER BY date DESC LIMIT 1")
    fun getLastGamesResults() : Single<GameResult>

    @Query("SELECT * FROM CHARACTER_TABLE WHERE id = :id")
    fun getCharacterStatistics(id: Int) : Single<Character>

    @Query("SELECT wpm FROM GAME_RESULT_TABLE")
    fun getSpeed(): Single<Array<Double>>

    @Query("SELECT accuracy FROM GAME_RESULT_TABLE")
    fun getAccuracy(): Single<Array<Double>>



    @Query("SELECT paragraph FROM PARAGRAPH_TABLE WHERE difficulty = :difficulty ORDER BY random() LIMIT 1")
    fun getParagraphByDifficulty(difficulty: Difficulty): Single<String>

    @Insert
    fun insertCharacter(character: Character) : Completable

    @Insert
    fun insertGameResult(gameResult: GameResult) : Completable


}