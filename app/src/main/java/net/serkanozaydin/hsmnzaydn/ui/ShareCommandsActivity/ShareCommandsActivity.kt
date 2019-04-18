package net.serkanozaydin.hsmnzaydn.ui.ShareCommandsActivity

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_share_commands.*
import kotlinx.android.synthetic.main.toolbar.*
import net.ozaydin.serkan.easy_csv.EasyCsv
import net.ozaydin.serkan.easy_csv.FileCallback
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.Utility.shareFile
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.ui.adapters.WritableTitleRecylerViewAdapter
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import java.io.File
import java.util.*
import javax.inject.Inject

class ShareCommandsActivity : BaseActivity(), ShareCommandsActivityMvpView {


    val WRITER: Int = 1

    @Inject
    lateinit var presenter: ShareCommandsActivityPresenter<ShareCommandsActivityMvpView>

    lateinit var adapter: WritableTitleRecylerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_commands)

        (application as MvpApp).getActivityComponent()!!.injectShareCommandsActivity(this)
        presenter.onAttach(this)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        presenter.getCategoriesAndDb()

        adapter = WritableTitleRecylerViewAdapter(this@ShareCommandsActivity,
            object : WritableTitleRecylerViewAdapter.ItemListener {
                override fun onItemClick(item: Category, position: Int) {

                }
            })

        activity_share_commands_export_button.setOnClickListener {

            presenter.shareCommands(adapter.getSelectedItems())
        }
    }

    override fun loadDataToList(response: List<Category>?) {
        adapter.setData(response)
        activity_share_commands_recylerview.layoutManager =
            LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        activity_share_commands_recylerview.adapter = adapter
    }

    override fun shareCsvFile(headerList: ArrayList<String>, dataList: ArrayList<String>) {
        var easyCsv = EasyCsv(this@ShareCommandsActivity);




        easyCsv.createCsvFile(getString(R.string.app_name) + UUID.randomUUID(), headerList, dataList, WRITER, object :
            FileCallback {
            override fun onSuccess(p0: File?) {
                hideLoading()
                shareFile(p0!!, this@ShareCommandsActivity)
            }

            override fun onFail(p0: String?) {
                hideLoading()
                showError(p0!!)
            }

        })

    }
}
