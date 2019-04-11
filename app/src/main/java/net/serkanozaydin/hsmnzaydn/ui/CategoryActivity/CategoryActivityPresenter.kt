package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import android.util.Log
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.entity.Language
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter
import net.serkanozaydin.hsmnzaydn.ui.base.ListSelectItem

class CategoryActivityPresenter<V : CategoryActivityMvpView> constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), CategoryActivityMvpPresenter<V> {


    var commandList: List<Command> = ArrayList<Command>()
    var selectLanguageId:Int = 0

    override fun searchInCommands(newText: String) {
        mvpView.showLoading()
        dataManager.getCommand(newText, object : ServiceCallback<List<Command>> {
            override fun onSuccess(response: List<Command>?) {
                if(response != null){
                    commandList = response!!
                }
                mvpView.loadDataCommandList(commandList)
                mvpView.hideLoading()
            }

            override fun onError(errorCode: Int, errorMessage: String) {
                mvpView.showError(errorMessage)
                mvpView.hideLoading()
            }

        })
    }

    override fun getCategories() {
        mvpView.showLoading()
        dataManager.getCategories(object : ServiceCallback<List<Category>> {
            override fun onSuccess(response: List<Category>?) {
                mvpView.loadDataToList(response)
                mvpView.hideLoading()
            }

            override fun onError(errorCode: Int, errorMessage: String) {
                mvpView.showError(errorMessage)
                mvpView.hideLoading()
            }

        })
    }

    override fun filterInCommandList(newText: String) {
        var commands: ArrayList<Command> = ArrayList<Command>()
        for (command: Command in this.commandList) {
            if (command.title.contains(newText)) {
                commands!!.add(command)
            }
        }
        mvpView.loadDataCommandList(commands)

    }

    override fun showLanguageDialog() {
        dataManager.getLanguages(object : ServiceCallback<List<Language>>{
            override fun onSuccess(response: List<Language>?) {
                var languageList:ArrayList<String> = ArrayList<String>()
                for(language:Language in response!!){
                    languageList.add(language.language)
                }

                mvpView.showListDialog(languageList,mvpView.getActivity().getString(R.string.dialog_select_language),object :
                    ListSelectItem<Int>{
                    override fun selectedItem(select: Int?) {
                        selectLanguageId= select!!
                        dataManager.saveLanguage(response.get(selectLanguageId).languageShooter)
                        getCategories()
                    }

                })


            }

            override fun onError(errorCode: Int, errorMessage: String) {
                mvpView.showError(errorMessage)
            }

        })
    }

    override fun saveCommand(commandTitle: String, commandDescription: String) {
        dataManager.saveCommand(commandTitle,commandDescription)


    }

}