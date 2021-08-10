package net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.Utility.changeActivity
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivity
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import java.lang.Exception
import javax.inject.Inject

class SplashScreenActivity : BaseActivity(),SplashScreenActivityMvpView {


    @Inject
    lateinit var presenter:SplashScreenActivityMvpPresenter<SplashScreenActivityMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        (application as MvpApp).getActivityComponent()!!.injectSplashScreenActivity(this)

        presenter.onAttach(this)

        FirebaseMessaging.getInstance().subscribeToTopic("TERMINAL")
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            var token = ""

            try {
                token = task.result?:""
                presenter.splashConfiguration(token, Settings.Secure.getString(this.getContentResolver(),
                    Settings.Secure.ANDROID_ID))

            }catch (ex: Exception){

            }


        })

    }
    override fun openMainActivity() {
        var changeActivityObject= Intent(this@SplashScreenActivity,CategoryActivity::class.java)
        startActivity(changeActivityObject)
    }
}
