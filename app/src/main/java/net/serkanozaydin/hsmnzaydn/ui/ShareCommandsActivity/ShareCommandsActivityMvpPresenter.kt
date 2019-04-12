package net.serkanozaydin.hsmnzaydn.ui.ShareCommandsActivity

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.ui.base.MvpPresenter

interface ShareCommandsActivityMvpPresenter<V : ShareCommandsActivityMvpView> : MvpPresenter<V> {
    fun getCategoriesAndDb()
    fun shareCommands(selectedItems: List<Category>)
}