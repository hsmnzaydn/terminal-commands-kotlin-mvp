package net.serkanozaydin.hsmnzaydn.data.services.CategoryServices

import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command


interface CategoryServices {

    fun getCategories(language:String, callback: Callback<List<Category>>)
    fun getCommandsOfCategory(categoryId:String,callback: Callback<List<Command>>)
}