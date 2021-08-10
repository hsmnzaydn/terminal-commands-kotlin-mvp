package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.ui.base.MvpView

interface CategoryActivityMvpView : MvpView {
    fun loadDataToList(response: List<Category>?)
    fun loadDataCommandList(commandList: List<Command>)

}