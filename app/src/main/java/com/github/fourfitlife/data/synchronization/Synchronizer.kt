package com.github.fourfitlife.data.synchronization

import com.github.fourfitlife.FourFitLife
import com.github.fourfitlife.data.remote.Api
import com.github.fourfitlife.helpers.SharedPreferencesHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Synchronizer {
    companion object {
        suspend fun run() = withContext(Dispatchers.IO) {
            val userId = SharedPreferencesHelper.userId
            userId ?: return@withContext
            val call = Api.service.getUserExercises(userId).execute()
            if (call.isSuccessful) {
                val userExercises = call.body()
                if (userExercises == null || userExercises.isEmpty())
                    return@withContext

                FourFitLife.db.userExerciseDao().clean()
                FourFitLife.db.userExerciseDao().insertAll(userExercises)
                SynchronizerInterface.notify(true)
            } else {
                SynchronizerInterface.notify(false)
            }
        }
    }
}
