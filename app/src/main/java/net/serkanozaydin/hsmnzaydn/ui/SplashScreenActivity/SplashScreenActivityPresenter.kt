package net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity

import net.serkanozaydin.hsmnzaydn.data.entity.UserRegisterRequest
import net.serkanozaydin.hsmnzaydn.data.entity.UserRegisterResponse
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter

class SplashScreenActivityPresenter<V : SplashScreenActivityMvpView>  constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), SplashScreenActivityMvpPresenter<V> {
    override fun splashConfiguration(pnsToken:String,udid:String) {
        dataManager.registerUser(UserRegisterRequest(pnsToken, udid),object :
            ServiceCallback<UserRegisterResponse> {
            override fun onSuccess(response: UserRegisterResponse?) {
                mvpView.openMainActivity()

            }

            override fun onError(errorCode: Int, errorMessage: String) {
            }

        })

    }
}