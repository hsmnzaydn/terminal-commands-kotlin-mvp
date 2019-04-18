package net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity

import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

class SplashScreenActivityPresenter<V : SplashScreenActivityMvpView>  constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), SplashScreenActivityMvpPresenter<V> {
    override fun splashConfiguration() {
        Timer("SettingUp",false).schedule(2000){
            mvpView.openMainActivity()
        }
    }
}