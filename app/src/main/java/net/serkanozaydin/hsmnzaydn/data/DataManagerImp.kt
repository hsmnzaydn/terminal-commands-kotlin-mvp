package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
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


    override fun getCategories(callback: Callback<List<Category>>) {
        apiServices!!.getCategories(prefHelper.getLanguage(), callback)

    }

    override fun getCommandsOfCategory(categoryId: String, callback: Callback<List<Command>>) {
        apiServices.getCommandsOfCategory(categoryId,callback)
    }

    override fun getCommand(query: String, callback: Callback<List<Command>>) {
        apiServices.getCommandQuery(prefHelper.getLanguage(),query,callback)
    }
}