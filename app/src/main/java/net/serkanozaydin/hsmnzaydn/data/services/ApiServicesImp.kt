package net.serkanozaydin.hsmnzaydn.data.services

import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServices
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServices
import javax.inject.Inject

class ApiServicesImp: ApiServices {


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

    override fun getCommandsOfCategory(categoryId: String, callback: Callback<List<Command>>) {
        categoryServices.getCommandsOfCategory(categoryId,callback)
    }

    override fun getCommandQuery(language: String, query: String, callback: Callback<List<Command>>) {
        commandServices.getCommandQuery(language,query,callback)
    }
}