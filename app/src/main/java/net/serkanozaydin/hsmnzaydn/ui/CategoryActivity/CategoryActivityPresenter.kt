package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter

class CategoryActivityPresenter<V : CategoryActivityMvpView> constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), CategoryActivityMvpPresenter<V> {


    lateinit var commandList: List<Command>

    override fun searchInCommands(newText: String) {
        mvpView.showLoading()
        dataManager.getCommand(newText, object : ServiceCallback<List<Command>> {
            override fun onSuccess(response: List<Command>?) {
                commandList = response!!
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
}