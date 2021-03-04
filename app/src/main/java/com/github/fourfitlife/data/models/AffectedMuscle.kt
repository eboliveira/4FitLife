package com.github.fourfitlife.data.models

import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity(tableName = "affected_muscle")
@Serializable
data class AffectedMuscle(
    val intensity: Float? = null,

    @Embedded
    val muscle: Muscle? = null
)
