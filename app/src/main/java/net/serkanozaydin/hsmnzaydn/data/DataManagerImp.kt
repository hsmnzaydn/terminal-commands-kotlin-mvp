package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.db.DBServices
import net.serkanozaydin.hsmnzaydn.data.db.DBServicesImp
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.entity.Language
import net.serkanozaydin.hsmnzaydn.data.pref.PrefHelper
import net.serkanozaydin.hsmnzaydn.data.services.ApiServices
import java.util.*
import javax.inject.Inject

class DataManagerImp : DataManager {


    lateinit var apiServices: ApiServices
    lateinit var prefHelper: PrefHelper
    lateinit var dbHelper: DBServices
    @Inject
    constructor(apiServices: ApiServices, prefHelper: PrefHelper,dbHelper: DBServices) {
        this.apiServices = apiServices
        this.prefHelper = prefHelper
        this.dbHelper=dbHelper
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

    override fun getLanguage(): String {
        return prefHelper.getLanguage()
    }

    override fun saveLanguage(language: String) {
        prefHelper.saveLanguage(language)
    }

    override fun saveCommand(title: String, description: String) {
        var command=Command( id = "",description = description,title = title);
        dbHelper.addCommand(command)
    }

    override fun deleteCommandFromDb(id:Int,title: String, description: String) {
        var command=Command(id = "",description = description,title = title);
        dbHelper.deleteCommand(command)

    }

    override fun getAllCommandFromDb(callback: ServiceCallback<List<Command>>) {
        dbHelper.getAllCommands(callback)
    }
    override fun updateCommandFromDb(command: Command) {
        dbHelper.updateCommand(command)
    }


}