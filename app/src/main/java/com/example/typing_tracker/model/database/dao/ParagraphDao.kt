package com.example.typing_tracker.model.database.dao

import androidx.room.*
import com.example.typing_tracker.model.domain.Paragraph
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface ParagraphDao {
    @Insert
    fun insert(paragraph: Paragraph) : Completable

    @Delete
    fun delete(paragraph: Paragraph) : Completable

    @Update
    fun update(paragraph: Paragraph) : Completable

    @Query("SELECT * FROM PARAGRAPH_TABLE")
    fun getAllParagraphs() : Single<List<Paragraph>>

    @Query("DELETE FROM PARAGRAPH_TABLE")
    fun deleteAllParagraphs()
}