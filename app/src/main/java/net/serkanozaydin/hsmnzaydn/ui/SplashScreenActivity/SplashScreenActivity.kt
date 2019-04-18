package net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.Utility.changeActivity
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivity
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import javax.inject.Inject

class SplashScreenActivity : BaseActivity(),SplashScreenActivityMvpView {


    @Inject
    lateinit var presenter:SplashScreenActivityMvpPresenter<SplashScreenActivityMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        (application as MvpApp).getActivityComponent()!!.injectSplashScreenActivity(this)
        presenter.onAttach(this)

        presenter.splashConfiguration()

    }
    override fun openMainActivity() {
        var changeActivityObject= Intent(this@SplashScreenActivity,CategoryActivity::class.java)
        startActivity(changeActivityObject)
    }
}
