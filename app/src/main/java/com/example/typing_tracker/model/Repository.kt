package com.example.typing_tracker.model

import com.example.typing_tracker.model.database.TypingTrackerDatabase
import com.example.typing_tracker.model.domain.Character
import com.example.typing_tracker.model.domain.Paragraph
import com.example.typing_tracker.model.domain.Result
import io.reactivex.rxjava3.core.Completable

object Repository {
    private val resultDao = TypingTrackerDatabase.getInstanceWithoutContext().resultDao()
    private val characterDao = TypingTrackerDatabase.getInstanceWithoutContext().characterDao()
    private val paragraphDao = TypingTrackerDatabase.getInstanceWithoutContext().paragraphDao()

    fun insertResult(result: Result): Completable {
        return resultDao.insert(result)
    }

    fun deleteResult(result: Result): Completable {
        return resultDao.delete(result)
    }

    fun insertParagraph(paragraph: Paragraph): Completable {
        return paragraphDao.insert(paragraph)
    }

    fun deleteAllParagraphs()  {
         paragraphDao.deleteAllParagraphs()
    }

    fun insertCharacter(character:Character) : Completable {
        return characterDao.insert(character)
    }
}