package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.db.DBServices
import net.serkanozaydin.hsmnzaydn.data.entity.*
import net.serkanozaydin.hsmnzaydn.data.pref.PrefHelper
import net.serkanozaydin.hsmnzaydn.data.services.ApiServices
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
        var command= Command( id = "",description = description,title = title);
        dbHelper.addCommand(command)
    }

    override fun deleteCommandFromDb(id:Int,title: String, description: String) {
        var command= Command(id = "",description = description,title = title);
        dbHelper.deleteCommand(command)

    }

    override fun getAllCommandFromDb(callback: ServiceCallback<List<Command>>) {
        dbHelper.getAllCommands(callback)
    }
    override fun updateCommandFromDb(command: Command) {
        dbHelper.updateCommand(command)
    }

    override fun registerUser(
        userRegisterRequest: UserRegisterRequest,
        callback: ServiceCallback<UserRegisterResponse>
    ) {
        apiServices.userRegister(userRegisterRequest, object :ServiceCallback<UserRegisterResponse>{
            override fun onSuccess(response: UserRegisterResponse?) {
                if (response != null){
                    prefHelper.saveAuthorizationKey(response.authozationKey)
                }else{
                    prefHelper.saveAuthorizationKey("Authorization")
                }
                callback.onSuccess(response)
            }

            override fun onError(errorCode: Int, errorMessage: String) {
                callback.onError(errorCode, errorMessage)
            }

        })
    }

}