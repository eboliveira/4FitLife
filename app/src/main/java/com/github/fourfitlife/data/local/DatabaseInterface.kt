package com.github.fourfitlife.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.fourfitlife.FourFitLife
import com.github.fourfitlife.data.local.daos.UserExerciseDao
import com.github.fourfitlife.data.models.UserExercise

@Database(entities = [UserExercise::class],
    version = 1,
    exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class DatabaseInterface : RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: DatabaseInterface

        fun getDatabase(): DatabaseInterface {
            synchronized(DatabaseInterface::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        FourFitLife.context,
                        DatabaseInterface::class.java, "four-fit-life"
                    ).build()
                }
            }

            return INSTANCE
        }
    }

    abstract fun userExerciseDao(): UserExerciseDao
}
