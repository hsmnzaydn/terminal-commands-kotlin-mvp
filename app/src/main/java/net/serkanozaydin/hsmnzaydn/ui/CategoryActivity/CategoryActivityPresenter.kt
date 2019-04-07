package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter

class CategoryActivityPresenter<V : CategoryActivityMvpView>  constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), CategoryActivityMvpPresenter<V> {
    override fun getCategories() {
        mvpView.showLoading()
        dataManager.getCategories(object : Callback<List<Category>>{
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
}