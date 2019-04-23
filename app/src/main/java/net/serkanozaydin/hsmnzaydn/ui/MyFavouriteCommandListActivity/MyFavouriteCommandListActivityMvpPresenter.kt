package net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity

import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.base.MvpPresenter

interface MyFavouriteCommandListActivityMvpPresenter<V : MyFavouriteCommandListActivityMvpView> : MvpPresenter<V> {
    fun getCommandList()
    fun saveCommand(item: Command)
}