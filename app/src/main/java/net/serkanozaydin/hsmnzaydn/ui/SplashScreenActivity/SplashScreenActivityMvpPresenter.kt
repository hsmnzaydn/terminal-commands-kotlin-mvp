package net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity

import net.serkanozaydin.hsmnzaydn.ui.base.MvpPresenter

interface SplashScreenActivityMvpPresenter<V : SplashScreenActivityMvpView> : MvpPresenter<V> {
    fun splashConfiguration(pnsToken:String,udid:String)

}