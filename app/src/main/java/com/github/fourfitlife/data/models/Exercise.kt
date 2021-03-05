package com.github.fourfitlife.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Exercise(
    @PrimaryKey
    @ColumnInfo(name = "exercise_id")
    val id: String,

    val name: String,

    val instructions: ArrayList<String>,

    val affectedMuscles: ArrayList<AffectedMuscle>
)
