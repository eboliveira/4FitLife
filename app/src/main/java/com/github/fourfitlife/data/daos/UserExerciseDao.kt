package com.github.fourfitlife.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.fourfitlife.data.models.UserExercise
import java.util.*

@Dao
interface UserExerciseDao {
    @Insert
    fun insertAll(userExercises: List<UserExercise>)

    @Query("DELETE FROM user_exercise")
    fun clean()

    @Query("SELECT * FROM user_exercise where date = :date")
    fun getForDay(date: Date): Array<UserExercise>

    @Query("SELECT * FROM user_exercise")
    fun getAll(): Array<UserExercise>
}
