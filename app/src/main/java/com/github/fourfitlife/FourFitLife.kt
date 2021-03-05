package com.github.fourfitlife

import android.app.Application
import androidx.room.Room
import com.github.fourfitlife.data.local.DatabaseInterface
import com.github.fourfitlife.helpers.SharedPreferencesHelper

class FourFitLife : Application() {
    companion object {
        lateinit var db: DatabaseInterface
    }

    override fun onCreate() {
        super.onCreate()
        SharedPreferencesHelper(this)
        db = Room.databaseBuilder(
            applicationContext,
            DatabaseInterface::class.java, "four-fit-life"
        ).build()
    }
}
