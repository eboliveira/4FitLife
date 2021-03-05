package com.github.fourfitlife.data

import androidx.room.TypeConverter
import com.github.fourfitlife.data.models.AffectedMuscle
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RoomConverters {
    @TypeConverter
    fun arrayListToJson(value: ArrayList<String>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToArrayList(value: String): ArrayList<String> =
        Gson().fromJson(value, Array<String>::class.java).toCollection(ArrayList())

    @TypeConverter
    fun affectedMuscleToJson(value: ArrayList<AffectedMuscle>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToAffectedMuscle(value: String): ArrayList<AffectedMuscle> =
        Gson().fromJson(value, Array<AffectedMuscle>::class.java).toCollection(ArrayList())

    @TypeConverter
    fun stringToDate(value: String): Date {
        val sdf = SimpleDateFormat("MMM DD, yyyy HH:MM:ss aa", Locale.ENGLISH)
        return sdf.parse(value) ?: Date()
    }

    @TypeConverter
    fun dateToString(value: Date): String {
        val sdf = SimpleDateFormat("MMM DD, yyyy HH:MM:ss aa", Locale.ENGLISH)
        return sdf.format(value)
    }
}
