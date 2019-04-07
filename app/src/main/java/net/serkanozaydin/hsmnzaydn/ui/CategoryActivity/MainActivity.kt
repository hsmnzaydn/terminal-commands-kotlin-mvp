package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(),CategoryActivityMvpView {


    @Inject
    lateinit var presenter: CategoryActivityMvpPresenter<CategoryActivityMvpView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MvpApp).getActivityComponent()!!.injectMainActivity(this)

        presenter.onAttach(this)
        presenter.getCategories();
    }
}
