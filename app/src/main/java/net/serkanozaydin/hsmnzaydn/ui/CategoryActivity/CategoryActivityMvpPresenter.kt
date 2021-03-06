package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import net.serkanozaydin.hsmnzaydn.ui.base.MvpPresenter

interface CategoryActivityMvpPresenter<V : CategoryActivityMvpView> : MvpPresenter<V> {
    fun getCategories()
    fun searchInCommands(newText: String)
    fun filterInCommandList(newText: String)
    fun showLanguageDialog()
    fun saveCommand(commandTitle: String, commandDescription: String)
    fun getCategoriesFromCache()
    fun downloadAllCommands()
}