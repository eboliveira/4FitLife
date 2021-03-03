package com.github.fourfitlife.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class UserExercise(
    @PrimaryKey val id: String,

    val exercise: Exercise,

    val repetitions: Int?,

    @ColumnInfo(name = "seconds_time") val secondsTime: Int?
)
