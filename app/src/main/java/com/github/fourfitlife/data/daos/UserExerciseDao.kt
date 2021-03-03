package com.github.fourfitlife.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.fourfitlife.data.models.UserExercise

@Dao
interface UserExerciseDao {
    @Insert
    fun insertAll(vararg userExercises: List<UserExercise>)

    @Query("DELETE FROM userexercise")
    fun clean()
}
