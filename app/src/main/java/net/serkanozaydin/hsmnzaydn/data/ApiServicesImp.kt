package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServices
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServices
import javax.inject.Inject

class ApiServicesImp:ApiServices {
    lateinit var categoryServices: CategoryServices
    lateinit var commandServices: CommandServices;

    @Inject
    constructor(categoryServices:CategoryServices,commandServices: CommandServices){
        this.categoryServices=categoryServices
        this.commandServices=commandServices
    }


    override fun getCategories(language: String, callback: Callback<List<Category>>) {
        categoryServices!!.getCategories(language,callback)
    }
}