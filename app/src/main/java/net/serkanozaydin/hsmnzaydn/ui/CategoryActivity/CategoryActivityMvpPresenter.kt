package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import net.serkanozaydin.hsmnzaydn.ui.base.MvpPresenter

interface CategoryActivityMvpPresenter<V : CategoryActivityMvpView> : MvpPresenter<V> {
    fun getCategories()
}