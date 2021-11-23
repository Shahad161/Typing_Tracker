package com.example.typing_tracker.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.typing_tracker.model.database.dao.CharacterDao
import com.example.typing_tracker.model.database.dao.ParagraphDao
import com.example.typing_tracker.model.database.dao.ResultDao
import com.example.typing_tracker.model.domain.Character
import com.example.typing_tracker.model.domain.Paragraph
import com.example.typing_tracker.model.domain.Result

@Database(entities = [Result::class, Paragraph::class, Character::class], version = 1)
@TypeConverters(Convertor::class)
abstract class TypingTrackerDatabase : RoomDatabase() {

    abstract fun resultDao(): ResultDao
    abstract fun paragraphDao(): ParagraphDao
    abstract fun characterDao(): CharacterDao

    companion object {
        @Volatile
        private var instance: TypingTrackerDatabase? = null

        fun getInstance(context: Context): TypingTrackerDatabase =
            instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }

        fun getInstanceWithoutContext(): TypingTrackerDatabase {
            return instance!!
        }

        private const val DATABASE_NAME = "TypingTrackerDatabase"
        private fun buildDatabase(context: Context): TypingTrackerDatabase {
            return Room.databaseBuilder(context, TypingTrackerDatabase::class.java, DATABASE_NAME)
                .createFromAsset("database/TypingTrackerDatabase.db").build()
        }
    }
}