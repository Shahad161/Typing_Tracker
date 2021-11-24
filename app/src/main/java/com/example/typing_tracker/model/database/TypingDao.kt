package com.example.typing_tracker.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.typing_tracker.model.domain.*
import io.reactivex.rxjava3.core.*

@Dao
interface TypingDao {

    @Query("SELECT * FROM GAME_RESULT_TABLE ORDER BY date DESC")
    fun getAllGamesResults() : Single<List<GameResult>>

    @Query("SELECT * FROM CHARACTER_TABLE WHERE id = :characterId")
    fun getCharacterStatistics(characterId: Int) : Single<Character>


    @Query("SELECT paragraph FROM PARAGRAPH_TABLE WHERE difficulty = :difficulty ORDER BY random() LIMIT 1")
    fun getParagraphByDifficulty(difficulty: String): Single<String>

    @Insert
    fun insertCharacter(character: Character) : Completable

    @Insert
    fun insertGameResult(gameResult: GameResult) : Completable


}