package net.serkanozaydin.hsmnzaydn.data.services

import hsmnzaydn.serkanozaydin.net.data.services.UserServices.UserServices
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.entity.*
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServices
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServices
import net.serkanozaydin.hsmnzaydn.data.services.LanguageServices.LanguageServices
import javax.inject.Inject

class ApiServicesImp: ApiServices {



    lateinit var categoryServices: CategoryServices
    lateinit var commandServices: CommandServices;
    lateinit var languageServices: LanguageServices
    lateinit var userServices: UserServices

    @Inject
    constructor(categoryServices:CategoryServices,commandServices: CommandServices,languageServices: LanguageServices,userServices: UserServices){
        this.categoryServices=categoryServices
        this.commandServices=commandServices
        this.languageServices=languageServices
        this.userServices = userServices
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


    override fun userRegister(
        userRegisterRequest: UserRegisterRequest,
        callback: ServiceCallback<UserRegisterResponse>
    ) {
        userServices.userRegister(userRegisterRequest,callback)
    }
}