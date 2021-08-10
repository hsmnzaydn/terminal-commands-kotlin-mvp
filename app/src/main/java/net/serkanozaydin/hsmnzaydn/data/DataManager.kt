package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.entity.*

interface DataManager {

    fun getCategories(serviceCallback: ServiceCallback<List<Category>>)
    fun getCommandsOfCategory(categoryId:String, serviceCallback: ServiceCallback<List<Command>>)
    fun getCommand(query:String, serviceCallback: ServiceCallback<List<Command>>)
    fun getLanguages(serviceCallback: ServiceCallback<List<Language>>)

    fun saveLanguage(language: String)
    fun getLanguage():String

    fun saveCommand(title:String,description:String)
    fun deleteCommandFromDb(id:Int,title: String,description: String)
    fun getAllCommandFromDb(callback: ServiceCallback<List<Command>>)
    fun updateCommandFromDb(command: Command)
    fun registerUser(userRegisterRequest: UserRegisterRequest, callback: ServiceCallback<UserRegisterResponse>)

}