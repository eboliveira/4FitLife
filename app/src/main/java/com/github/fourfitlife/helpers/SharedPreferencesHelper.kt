package com.github.fourfitlife.helpers

import android.content.Context

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: SharedPreferencesHelper
        private const val APP_SETTINGS = "app_settings"

        private const val USER_ID = "user_id"

        var userId: String?
            get() = instance.sharedPreferences.getString(USER_ID, null)
            set(value) {
                instance.editor.putString(USER_ID, value).apply()
            }
    }
}
