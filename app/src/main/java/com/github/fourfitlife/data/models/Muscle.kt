package com.github.fourfitlife.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Muscle(
    @PrimaryKey val id: String,
    val name: String,
    val group: MuscleGroup
)
