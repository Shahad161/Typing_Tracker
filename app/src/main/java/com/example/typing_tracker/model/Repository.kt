package com.example.typing_tracker.model

import com.example.typing_tracker.model.database.TypingDatabase
import com.example.typing_tracker.model.entities.*
import com.example.typing_tracker.util.Difficulty

object Repository {
    private val typingDao = TypingDatabase.getInstanceWithoutContext().typingDao()


    fun getAllGamesResults() = typingDao.getAllGamesResults()
    fun getLastGamesResults() = typingDao.getLastGamesResults()
    fun getWpm() = typingDao.getSpeed()

    fun getCharacterStatistics(characterId: Int) = typingDao.getCharacterStatistics(characterId)

    fun getParagraphByDifficulty(difficulty: Difficulty) =
        typingDao.getParagraphByDifficulty(difficulty)

    fun insertCharacter(character: Character) = typingDao.insertCharacter(character)

    fun insertGameResult(gameResult: GameResult) =
        typingDao.insertGameResult(gameResult)
}

