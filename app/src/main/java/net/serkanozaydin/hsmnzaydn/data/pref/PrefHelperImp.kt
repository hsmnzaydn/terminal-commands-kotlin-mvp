package net.serkanozaydin.hsmnzaydn.data.pref

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PrefHelperImp:PrefHelper {

    lateinit var mPrefs: SharedPreferences

    @Inject
    constructor(context:Context){
        mPrefs = context.getSharedPreferences("", Context.MODE_PRIVATE)
    }

    override fun saveLanguage(language: String) {
        mPrefs.edit().putString("LANGUAGE", language).apply()

    }

    override fun getLanguage(): String {
        return mPrefs.getString("LANGUAGE", "ENG")

    }

}