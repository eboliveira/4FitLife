package com.github.fourfitlife.data.remote

import com.github.fourfitlife.data.models.UserExercise
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("day/{userId}")
    fun getUserExercises(@Path("userId") userId: String): Call<List<UserExercise>>
}
