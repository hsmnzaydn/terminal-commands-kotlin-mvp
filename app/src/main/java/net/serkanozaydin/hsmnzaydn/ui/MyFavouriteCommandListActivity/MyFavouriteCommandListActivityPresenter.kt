package net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity

import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter
import javax.inject.Inject

class MyFavouriteCommandListActivityPresenter<V : MyFavouriteCommandListActivityMvpView>  constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), MyFavouriteCommandListActivityMvpPresenter<V> {
    override fun getCommandList() {
        mvpView.showLoading()
        dataManager.getAllCommandFromDb(object : ServiceCallback<List<Command>>{
            override fun onSuccess(response: List<Command>?) {
                mvpView.hideLoading()
                mvpView.loadDataToList(response)
            }

            override fun onError(errorCode: Int, errorMessage: String) {

            }

        })
    }
}