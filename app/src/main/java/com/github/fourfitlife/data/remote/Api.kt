package com.github.fourfitlife.data.remote

import retrofit2.Retrofit


class Api {
    companion object {
        private const val baseUrl = "https://2045afe6dd34.ngrok.io"
        private val client = Retrofit.Builder()
            .baseUrl(baseUrl)
            .build()

        val service = client.create(ApiInterface::class.java)
    }


}
