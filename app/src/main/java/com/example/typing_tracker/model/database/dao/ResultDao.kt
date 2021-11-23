package com.example.typing_tracker.model.database.dao

import androidx.room.*
import com.example.typing_tracker.model.domain.Result
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface ResultDao {
    @Insert
    fun insert(result: Result) : Completable

    @Delete
    fun delete(result: Result) : Completable

    @Update
    fun update(result: Result) : Completable

    @Query("SELECT * FROM RESULT_TABLE")
    fun getAllResults() : Single<List<Result>>
}
