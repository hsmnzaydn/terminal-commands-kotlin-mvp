package net.serkanozaydin.hsmnzaydn.ui.CommandListActivity

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_command_list.*
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
            override fun onEditClick(item: Command) {




            }

            override fun onItemClick(item: Command) {

                val dialogBuilder = AlertDialog.Builder(this@CommandListActivity)
                val inflater = layoutInflater
                val dialogView = inflater.inflate(R.layout.dialog_description_command, null)
                dialogBuilder.setView(dialogView)
                var commandTitle = dialogView.findViewById<TextView>(R.id.dialog_description_command_title_text_view)
                var commandDescription =
                    dialogView.findViewById<TextView>(R.id.dialog_description_command_description_text_view)

                commandTitle.text=item.title
                commandDescription.text=item.description


                val alertDialog = dialogBuilder.create()
                alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                alertDialog.show()




            }

        },false)
        setSupportActionBar(toolbar)
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
