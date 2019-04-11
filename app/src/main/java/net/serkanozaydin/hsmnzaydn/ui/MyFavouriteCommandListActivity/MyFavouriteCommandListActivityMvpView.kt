package net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity

import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.base.MvpView

interface MyFavouriteCommandListActivityMvpView : MvpView {
    fun loadDataToList(response: List<Command>?)
}