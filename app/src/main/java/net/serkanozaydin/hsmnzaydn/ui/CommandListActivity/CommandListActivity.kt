package net.serkanozaydin.hsmnzaydn.ui.CommandListActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.Utility.BUNDLE_CATEGORY_ID
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import javax.inject.Inject

class CommandListActivity : BaseActivity(),CommandListActivityMvpView {


    @Inject
    lateinit var presenter:CommandListActivityPresenter<CommandListActivityMvpView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_command_list)

        (application as MvpApp).getActivityComponent()!!.injectCommandListActivity(this)

        presenter.onAttach(this)

        var bundle:Bundle??=intent.extras

        var categoryId= bundle!!.getString(BUNDLE_CATEGORY_ID,"")
        presenter.getCommandsOfCategory(categoryId)

    }


    override fun loadDataToList(response: List<Command>?) {


    }

}
