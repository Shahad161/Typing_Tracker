package com.example.typing_tracker.model

import com.example.typing_tracker.model.database.TypingDatabase
import com.example.typing_tracker.model.domain.*

object Repository {
    private val typingDao = TypingDatabase.getInstanceWithoutContext().typingDao()


    fun getAllGamesResults() = typingDao.getAllGamesResults()

    fun getCharacterStatistics(characterId: Int) = typingDao.getCharacterStatistics(characterId)

    fun getParagraphByDifficulty(difficulty: String) =
        typingDao.getParagraphByDifficulty(difficulty)

    fun insertCharacter(character: Character) = typingDao.insertCharacter(character)

    fun insertGameResult(gameResult: GameResult) =
        typingDao.insertGameResult(gameResult)
}

