package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.entity.Language
import net.serkanozaydin.hsmnzaydn.data.pref.PrefHelper
import net.serkanozaydin.hsmnzaydn.data.services.ApiServices
import javax.inject.Inject

class DataManagerImp : DataManager {


    lateinit var apiServices: ApiServices
    lateinit var prefHelper: PrefHelper

    @Inject
    constructor(apiServices: ApiServices, prefHelper: PrefHelper) {
        this.apiServices = apiServices
        this.prefHelper = prefHelper
    }


    override fun getCategories(serviceCallback: ServiceCallback<List<Category>>) {
        apiServices!!.getCategories(serviceCallback)

    }

    override fun getCommandsOfCategory(categoryId: String, serviceCallback: ServiceCallback<List<Command>>) {
        apiServices.getCommandsOfCategory(categoryId,serviceCallback)
    }

    override fun getCommand(query: String, serviceCallback: ServiceCallback<List<Command>>) {
        apiServices.getCommandQuery(query,serviceCallback)
    }
    override fun getLanguages(serviceCallback: ServiceCallback<List<Language>>) {
        apiServices.getLanguages(serviceCallback)
    }

}