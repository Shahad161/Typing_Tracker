package com.example.typing_tracker.model.database

import android.content.Context
import androidx.room.*
import com.example.typing_tracker.model.domain.*


@Database(
    entities = [GameResult::class, Paragraph::class, Character::class],
    version = 1,
)
@TypeConverters(Convertor::class)
abstract class TypingDatabase : RoomDatabase() {

    abstract fun typingDao(): TypingDao

    companion object {

        private const val DATABASE_NAME = "TypingDatabase"
        private const val DATABASE_PATH ="database/TypingDatabase.db"

        @Volatile
        private var instance: TypingDatabase? = null

        fun getInstance(context: Context): TypingDatabase =
            instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }

        fun getInstanceWithoutContext(): TypingDatabase {
            return instance!!
        }

        private fun buildDatabase(context: Context): TypingDatabase {
            return Room.databaseBuilder(context, TypingDatabase::class.java, DATABASE_NAME)
                .createFromAsset(DATABASE_PATH).build()
        }
    }
}