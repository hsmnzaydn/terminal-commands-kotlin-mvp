package net.serkanozaydin.hsmnzaydn.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import net.serkanozaydin.hsmnzaydn.data.db.DBServices
import net.serkanozaydin.hsmnzaydn.data.entity.*
import net.serkanozaydin.hsmnzaydn.data.pref.PrefHelper
import net.serkanozaydin.hsmnzaydn.data.services.ApiServices
import javax.inject.Inject

class DataManagerImp : DataManager {


    lateinit var apiServices: ApiServices
    lateinit var prefHelper: PrefHelper
    lateinit var dbHelper: DBServices
    lateinit var context: Context
    @Inject
    constructor(context: Context,apiServices: ApiServices, prefHelper: PrefHelper,dbHelper: DBServices) {
        this.context = context
        this.apiServices = apiServices
        this.prefHelper = prefHelper
        this.dbHelper=dbHelper
    }


    override fun getCategories(serviceCallback: ServiceCallback<List<Category>>) {
        if(!hasNetwork(context)!!){
            serviceCallback.onSuccess(prefHelper.getCategories())
        }else{
            apiServices!!.getCategories(object :ServiceCallback<List<Category>>{
                override fun onSuccess(response: List<Category>?) {
                    prefHelper.saveAllCategory(response!!)
                    serviceCallback.onSuccess(response)
                }

                override fun onError(errorCode: Int, errorMessage: String) {
                    serviceCallback.onError(errorCode, errorMessage)
                }

            })
        }


    }

    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

    override fun getCommandsOfCategory(categoryId: String, serviceCallback: ServiceCallback<List<Command>>) {
        apiServices.getCommandsOfCategory(categoryId,object :ServiceCallback<List<Command>>{
            override fun onSuccess(response: List<Command>?) {

                if(!hasNetwork(context)!!){
                    serviceCallback.onSuccess(getCommandsFromsCache(categoryId))
                }else{
                    var cacheCommandList = prefHelper.getCommands().toMutableList()

                    for(command in response!!){
                        cacheCommandList.find {
                            it.id.equals(command.id)
                        }.apply {

                        }?: kotlin.run {
                            var tempCommand = command
                            tempCommand.categoryId = categoryId
                            cacheCommandList.add(tempCommand)
                            prefHelper.saveAllCommands(cacheCommandList)
                        }
                    }

                    serviceCallback.onSuccess(response)
                }



            }

            override fun onError(errorCode: Int, errorMessage: String) {
                serviceCallback.onError(errorCode, errorMessage)
            }

        })
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

    override fun saveAllCategories(list: List<Category>) {
        prefHelper.saveAllCategory(list)
    }

    override fun saveAllCommands(list: List<Command>) {
        prefHelper.saveAllCommands(list)
    }

    override fun getCategoriesFromCache(): List<Category> {
        return prefHelper.getCategories()
    }

    override fun getCommandsFromsCache(categoryId: String): List<Command> {
         prefHelper.getCommands().filter {
            it.categoryId == categoryId
        }.apply {
            return this
        }
    }

}