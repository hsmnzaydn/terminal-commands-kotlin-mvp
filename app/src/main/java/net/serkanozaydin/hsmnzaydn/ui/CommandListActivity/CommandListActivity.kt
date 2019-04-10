package net.serkanozaydin.hsmnzaydn.ui.CommandListActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_command_list.*
import kotlinx.android.synthetic.main.content_navigation.*
import kotlinx.android.synthetic.main.toolbar.*
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.Utility.BUNDLE_CATEGORY_ID
import net.serkanozaydin.hsmnzaydn.Utility.BUNDLE_CATEGORY_NAME
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.adapters.CommandRecylerviewAdapter
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import javax.inject.Inject

class CommandListActivity : BaseActivity(), CommandListActivityMvpView {


    @Inject
    lateinit var presenter: CommandListActivityPresenter<CommandListActivityMvpView>

    lateinit var adapter:CommandRecylerviewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_command_list)

        (application as MvpApp).getActivityComponent()!!.injectCommandListActivity(this)

        presenter.onAttach(this)

        var bundle: Bundle?? = intent.extras

        var categoryId = bundle!!.getString(BUNDLE_CATEGORY_ID, "")
        var categoryName=bundle.getString(BUNDLE_CATEGORY_NAME,"")
        setTitle(categoryName)
        presenter.getCommandsOfCategory(categoryId)

        adapter= CommandRecylerviewAdapter(object : CommandRecylerviewAdapter.ItemListener{
            override fun onItemClick(item: Command) {

            }

        })
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


    }


    override fun loadDataToList(response: List<Command>?) {
        adapter.setData(response)
        activity_command_list_recylerview.layoutManager =
            LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        activity_command_list_recylerview.adapter = adapter

    }

}
