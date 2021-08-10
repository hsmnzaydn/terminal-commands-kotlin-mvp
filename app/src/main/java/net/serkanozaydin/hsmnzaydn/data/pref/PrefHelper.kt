package net.serkanozaydin.hsmnzaydn.data.pref

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command

interface PrefHelper {
    fun saveLanguage(language:String)
    fun getLanguage():String
    fun saveAuthorizationKey(authorizationKey:String)
    fun getAuthorizationKey():String
    fun saveAllCommands(commandList:List<Command>)
    fun saveAllCategory(categoryList:List<Category>)
    fun getCommands():List<Command>
    fun getCategories():List<Category>

}