package com.github.fourfitlife.data.remote

import com.github.fourfitlife.data.models.UserExercise
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {
    @GET("day")
    fun getUserExercises(@Query("userId") userId: String): Call<List<UserExercise>>
}
