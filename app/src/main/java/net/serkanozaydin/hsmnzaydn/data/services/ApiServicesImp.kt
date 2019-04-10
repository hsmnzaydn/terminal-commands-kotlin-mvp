package net.serkanozaydin.hsmnzaydn.data.services

import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.entity.Language
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServices
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServices
import net.serkanozaydin.hsmnzaydn.data.services.LanguageServices.LanguageServices
import javax.inject.Inject

class ApiServicesImp: ApiServices {



    lateinit var categoryServices: CategoryServices
    lateinit var commandServices: CommandServices;
    lateinit var languageServices: LanguageServices

    @Inject
    constructor(categoryServices:CategoryServices,commandServices: CommandServices,languageServices: LanguageServices){
        this.categoryServices=categoryServices
        this.commandServices=commandServices
        this.languageServices=languageServices
    }


    override fun getCategories(serviceCallback: ServiceCallback<List<Category>>) {
        categoryServices!!.getCategories(serviceCallback)
    }

    override fun getCommandsOfCategory(categoryId: String, serviceCallback: ServiceCallback<List<Command>>) {
        categoryServices.getCommandsOfCategory(categoryId,serviceCallback)
    }

    override fun getCommandQuery(query: String, serviceCallback: ServiceCallback<List<Command>>) {
        commandServices.getCommandQuery(query,serviceCallback)
    }

    override fun getLanguages(callback: ServiceCallback<List<Language>>) {
        languageServices.getLanguages(callback)
    }
}