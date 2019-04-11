package net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity

import net.serkanozaydin.hsmnzaydn.ui.base.MvpPresenter

interface MyFavouriteCommandListActivityMvpPresenter<V : MyFavouriteCommandListActivityMvpView> : MvpPresenter<V> {
    fun getCommandList()
}