package com.github.fourfitlife.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.fourfitlife.data.daos.UserExerciseDao
import com.github.fourfitlife.data.models.UserExercise

@Database(entities = [UserExercise::class], version = 1)
abstract class DatabaseInterface : RoomDatabase() {
    companion object {
        lateinit var instance: DatabaseInterface
    }

    abstract fun userExerciseDao(): UserExerciseDao
}
