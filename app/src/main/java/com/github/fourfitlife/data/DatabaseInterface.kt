package com.github.fourfitlife.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.fourfitlife.data.daos.UserExerciseDao
import com.github.fourfitlife.data.models.AffectedMuscle
import com.github.fourfitlife.data.models.Exercise
import com.github.fourfitlife.data.models.Muscle
import com.github.fourfitlife.data.models.UserExercise

@Database(entities = [UserExercise::class],
    version = 1,
    exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class DatabaseInterface : RoomDatabase() {
    abstract fun userExerciseDao(): UserExerciseDao
}
