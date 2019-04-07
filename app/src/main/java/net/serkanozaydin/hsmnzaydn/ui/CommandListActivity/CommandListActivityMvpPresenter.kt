package net.serkanozaydin.hsmnzaydn.ui.CommandListActivity

import net.serkanozaydin.hsmnzaydn.ui.base.MvpPresenter

interface CommandListActivityMvpPresenter<V : CommandListActivityMvpView> : MvpPresenter<V> {
    fun getCommandsOfCategory(categoryId: String?)
}