package net.serkanozaydin.hsmnzaydn.ui.base


import net.serkanozaydin.hsmnzaydn.data.DataManager

import javax.inject.Inject

open class BasePresenter<V : MvpView>
constructor(dataManager: DataManager) : MvpPresenter<V> {

    lateinit var mvpView: V


    var dataManager: DataManager
        @Inject set

    init {
        this.dataManager = dataManager
    }

    override fun onAttach(mMvpView: V) {
        mvpView = mMvpView
    }
}

