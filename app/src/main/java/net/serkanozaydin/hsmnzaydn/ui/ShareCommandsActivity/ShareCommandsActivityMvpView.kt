package net.serkanozaydin.hsmnzaydn.ui.ShareCommandsActivity

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.ui.base.MvpView

interface ShareCommandsActivityMvpView : MvpView {
    fun loadDataToList(response: List<Category>?)
    fun shareCsvFile(headerList: ArrayList<String>, dataList: ArrayList<String>)
}