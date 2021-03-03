package com.github.fourfitlife.data.models

import kotlinx.serialization.Serializable

@Serializable
data class AffectedMuscle(
    val intensity: Float,
    val muscle: Muscle
)
