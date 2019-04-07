package net.serkanozaydin.hsmnzaydn.ui.base

interface MvpPresenter<V : MvpView> {
    fun onAttach(mvpView: V)
}
