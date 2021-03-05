package com.github.fourfitlife.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Api {
    companion object {
        private const val baseUrl = " https://89aa30943972.ngrok.io"
        private val client = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = client.create(ApiInterface::class.java)
    }


}
