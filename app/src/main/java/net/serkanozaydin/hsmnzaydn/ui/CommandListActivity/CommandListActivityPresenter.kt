package net.serkanozaydin.hsmnzaydn.ui.CommandListActivity

import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter
import javax.inject.Inject

class CommandListActivityPresenter<V : CommandListActivityMvpView>  constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), CommandListActivityMvpPresenter<V> {
    override fun getCommandsOfCategory(categoryId: String?) {
        mvpView.showLoading()
        dataManager.getCommandsOfCategory(categoryId!!,object : Callback<List<Command>>{
            override fun onSuccess(response: List<Command>?) {
                mvpView.hideLoading()
                mvpView.loadDataToList(response)
            }

            override fun onError(errorCode: Int, errorMessage: String) {

                mvpView.showError(errorMessage)
                mvpView.hideLoading()
            }

        })
    }
}