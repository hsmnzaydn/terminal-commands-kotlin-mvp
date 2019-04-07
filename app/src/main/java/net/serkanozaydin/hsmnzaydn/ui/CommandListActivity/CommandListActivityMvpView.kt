package net.serkanozaydin.hsmnzaydn.ui.CommandListActivity

import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.base.MvpView

interface CommandListActivityMvpView : MvpView {
     fun loadDataToList(response: List<Command>?)
}