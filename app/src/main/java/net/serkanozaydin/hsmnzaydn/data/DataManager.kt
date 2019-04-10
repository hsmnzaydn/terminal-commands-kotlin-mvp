package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.entity.Language

interface DataManager {

    fun getCategories(serviceCallback: ServiceCallback<List<Category>>)
    fun getCommandsOfCategory(categoryId:String, serviceCallback: ServiceCallback<List<Command>>)
    fun getCommand(query:String, serviceCallback: ServiceCallback<List<Command>>)
    fun getLanguages(serviceCallback: ServiceCallback<List<Language>>)

    fun saveLanguage(language: String)
    fun getLanguage():String
}