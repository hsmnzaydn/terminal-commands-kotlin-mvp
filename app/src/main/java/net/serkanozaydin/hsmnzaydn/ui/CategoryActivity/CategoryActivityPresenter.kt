package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import android.util.Log
import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter
import javax.inject.Inject

class CategoryActivityPresenter<V : CategoryActivityMvpView>  constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), CategoryActivityMvpPresenter<V> {
    override fun getCategories() {
        mvpView.showLoading()
        dataManager.getCategories("TR",object : Callback<List<Category>>{
            override fun onSuccess(response: List<Category>?) {
            }

            override fun onError(errorCode: Int, errorMessage: String) {

            }

        })
    }
}