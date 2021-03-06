package com.github.fourfitlife

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.github.fourfitlife.data.local.DatabaseInterface
import com.github.fourfitlife.helpers.SharedPreferencesHelper

class FourFitLife : Application() {
    companion object {
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = this
        SharedPreferencesHelper(this)
    }
}
