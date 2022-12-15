package com.doriangrei.apueastawinapp.controller

import android.content.SharedPreferences
import com.doriangrei.apueastawinapp.model.Level
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class LocalStorageController(private val preferences: SharedPreferences) {

    fun getUser(): ArrayList<Level>? {
        val json = preferences.getString(USER_PROFILE, null)

        return if (json != null) {
            val listType: Type = object : TypeToken<ArrayList<Level?>?>() {}.type
            Gson().fromJson(json, listType)
        } else null
    }

    fun saveResults(
        listLevels: ArrayList<Level>
    ) {
        preferences.edit().apply {
            putString(USER_PROFILE, Gson().toJson(listLevels))
        }.apply()
    }

    companion object {
        private const val USER_PROFILE = "user_profile"
    }
}