package com.github.fourfitlife.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Entity(tableName = "user_exercise")
@Serializable
data class UserExercise(
    @PrimaryKey
    @ColumnInfo(name = "user_exercise_id")
    val id: String,

    @Embedded
    val exercise: Exercise,

    val repetitions: Int?,

    @ColumnInfo(name = "seconds_time")
    val secondsTime: Int?,

    @Contextual
    val date: Date
)
