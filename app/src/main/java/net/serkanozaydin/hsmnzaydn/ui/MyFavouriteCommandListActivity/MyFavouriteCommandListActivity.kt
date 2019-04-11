package net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_my_favourite_command_list.*
import kotlinx.android.synthetic.main.content_navigation.*
import kotlinx.android.synthetic.main.toolbar.*
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.adapters.CommandRecylerviewAdapter
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import javax.inject.Inject

class MyFavouriteCommandListActivity : BaseActivity(),MyFavouriteCommandListActivityMvpView {

    @Inject
    lateinit var presenter: MyFavouriteCommandListActivityMvpPresenter<MyFavouriteCommandListActivityMvpView>

    lateinit var adapter: CommandRecylerviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_favourite_command_list)

        (application as MvpApp).getActivityComponent()!!.injectMyFavouriteCommandListActivity(this)
        presenter.onAttach(this)

        presenter.getCommandList()
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        adapter= CommandRecylerviewAdapter(object : CommandRecylerviewAdapter.ItemListener{
            override fun onItemClick(item: Command) {

            }

        })
    }


    override fun loadDataToList(response: List<Command>?) {
        adapter.setData(response)
        activity_my_favourite_command_list_activity_recylerview.layoutManager =
            LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        activity_my_favourite_command_list_activity_recylerview.adapter = adapter
    }

}
