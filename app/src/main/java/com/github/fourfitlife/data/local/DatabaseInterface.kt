package com.github.fourfitlife.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.fourfitlife.data.local.daos.UserExerciseDao
import com.github.fourfitlife.data.models.UserExercise

@Database(entities = [UserExercise::class],
    version = 1,
    exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class DatabaseInterface : RoomDatabase() {
    abstract fun userExerciseDao(): UserExerciseDao
}
