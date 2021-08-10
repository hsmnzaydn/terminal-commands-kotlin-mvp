package net.serkanozaydin.hsmnzaydn.data.services.CategoryServices

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback


interface CategoryServices {

    fun getCategories(serviceCallback: ServiceCallback<List<Category>>)
    fun getCommandsOfCategory(categoryId:String, serviceCallback: ServiceCallback<List<Command>>)
}