package com.example.typing_tracker.model.database.dao

import androidx.room.*
import com.example.typing_tracker.model.domain.Character
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
@Dao
interface CharacterDao {
    @Insert
    fun insert(character: Character) : Completable

    @Delete
    fun delete(character: Character) : Completable

    @Update
    fun update(character: Character) : Completable

    @Query("SELECT * FROM CHARACTER_TABLE")
    fun getAllCharacters() : Single<List<Character>>
}