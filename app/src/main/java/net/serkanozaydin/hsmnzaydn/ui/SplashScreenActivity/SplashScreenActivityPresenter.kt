package net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity

import net.serkanozaydin.hsmnzaydn.Utility.SPLASH_DELAY
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

class SplashScreenActivityPresenter<V : SplashScreenActivityMvpView>  constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), SplashScreenActivityMvpPresenter<V> {
    override fun splashConfiguration() {
        Timer("SettingUp",false).schedule(SPLASH_DELAY){
            mvpView.openMainActivity()
        }
    }
}