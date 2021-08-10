package net.serkanozaydin.hsmnzaydn.data.pref

import android.content.Context
import android.content.SharedPreferences
import java.util.*
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
        var language:String=Locale.getDefault().getISO3Language().toUpperCase();

        when (language){
            "TUR" -> language="TR"
            "FRA" -> language="FRA"
            else ->{
                language="ENG"
            }
        }
        return mPrefs.getString("LANGUAGE",language)!!

    }

    override fun saveAuthorizationKey(authorizationKey: String) {
        mPrefs.edit().putString("Authorization",authorizationKey).apply()
    }

    override fun getAuthorizationKey(): String {
        return mPrefs.getString("Authorization","")?:""
    }

}