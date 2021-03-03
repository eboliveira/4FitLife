package com.github.fourfitlife.ui.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Exercise(
    @PrimaryKey val id: String,
    val name: String,
    val instructions: List<String>,
    @ColumnInfo(name = "affected_muscles") val affectedMuscles: List<AffectedMuscle>
)
