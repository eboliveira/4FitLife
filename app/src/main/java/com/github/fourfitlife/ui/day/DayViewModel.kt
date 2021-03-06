package com.github.fourfitlife.ui.day

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.github.fourfitlife.data.models.UserExercise
import com.github.fourfitlife.data.repositories.UserExerciseRepository

// TODO Refactor this to be dynamic and can be used by other classes. It requires to implement Factory
// https://developer.android.com/codelabs/kotlin-android-training-view-model#7
class DayViewModel : ViewModel() {
    val userExercises = UserExerciseRepository.userExercises
}
