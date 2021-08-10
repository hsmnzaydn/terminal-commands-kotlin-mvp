package net.serkanozaydin.hsmnzaydn.data.pref

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
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

    override fun saveAllCommands(commandList: List<Command>) {
        mPrefs.edit().putString("commands",Gson().toJson(commandList)).apply()
    }

    override fun saveAllCategory(categoryList: List<Category>) {
        mPrefs.edit().putString("categories",Gson().toJson(categoryList)).apply()
    }

    override fun getCommands(): List<Command> {
        val itemType = object : TypeToken<List<Command>>() {}.type

        var commands = Gson().fromJson<List<Command>>(mPrefs.getString("commands",""),itemType)
        commands?.let {
            return it
        }?: kotlin.run {
            return emptyList()
        }
    }

    override fun getCategories(): List<Category> {
        val itemType = object : TypeToken<List<Category>>() {}.type

        return  Gson().fromJson<List<Category>>(mPrefs.getString("categories",""),itemType)
    }

}