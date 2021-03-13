package com.example.sharedpreferences

import android.content.Context

class ProfilPref(context: Context){
    companion object{
        const val SP_NAME = "profil_pref"
        const val NAME = "name"
        const val AGE = "age"
        const val GENDER = "gender"
    }

    val preference = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun setProfile(profile: dataProfile){
        val prefEditor = preference.edit()
        prefEditor.putString(NAME, profile.name)
        profile.age?.let { prefEditor.putInt(AGE, it) }
        prefEditor.putString(GENDER, profile.gender)
        prefEditor.apply()
    }

    fun getProfile(): dataProfile{
        val profile = dataProfile()
        profile.name = preference.getString(NAME, "").toString()
        profile.age = preference.getInt(AGE, 0)
        profile.gender = preference.getString(GENDER, "").toString()
        return profile
    }
}