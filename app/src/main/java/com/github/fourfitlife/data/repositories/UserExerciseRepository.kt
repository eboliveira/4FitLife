package com.github.fourfitlife.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.github.fourfitlife.data.local.DatabaseInterface
import com.github.fourfitlife.data.models.UserExercise
import com.github.fourfitlife.data.remote.Api
import com.github.fourfitlife.helpers.SharedPreferencesHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class UserExerciseRepository {
    companion object {
        val userExercises: LiveData<List<UserExercise>> =
            DatabaseInterface.getDatabase().userExerciseDao().getAll()

        suspend fun refresh() = withContext(Dispatchers.IO) {
            val userId = SharedPreferencesHelper.userId
            userId ?: return@withContext
            Api.service.getUserExercises(userId).enqueue(object : Callback<List<UserExercise>> {
                override fun onResponse(
                    call: Call<List<UserExercise>>,
                    response: Response<List<UserExercise>>,
                ) {
                    val userExercises = response.body() ?: return
                    runBlocking {
                        withContext(Dispatchers.IO) {
                            DatabaseInterface.getDatabase().userExerciseDao().clean()
                            DatabaseInterface.getDatabase().userExerciseDao().insertAll(userExercises)
                        }
                    }
                }

                override fun onFailure(call: Call<List<UserExercise>>, t: Throwable) {
                    // TODO Implement error handling
                }
            })
        }
    }
}
