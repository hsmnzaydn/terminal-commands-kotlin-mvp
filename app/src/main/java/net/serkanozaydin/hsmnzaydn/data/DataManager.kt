package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.services.ApiServices

interface DataManager {

    fun getCategories(callback: Callback<List<Category>>)
    fun getCommandsOfCategory(categoryId:String,callback: Callback<List<Command>>)
    fun getCommand(query:String,callback: Callback<List<Command>>)

}