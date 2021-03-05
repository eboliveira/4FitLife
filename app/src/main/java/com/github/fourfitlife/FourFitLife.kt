package com.github.fourfitlife

import android.app.Application
import androidx.room.Room
import com.github.fourfitlife.data.local.DatabaseInterface
import com.github.fourfitlife.helpers.SharedPreferencesHelper

class FourFitLife : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferencesHelper(this)
        DatabaseInterface.db = Room.databaseBuilder(
            applicationContext,
            DatabaseInterface::class.java, "four-fit-life"
        ).build()
    }
}
