package net.serkanozaydin.hsmnzaydn.data.services.CategoryServices

import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.entity.Category


interface CategoryServices {

    fun getCategories(language:String, callback: Callback<List<Category>>)
}