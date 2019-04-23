package net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
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
                val dialogBuilder = AlertDialog.Builder(this@MyFavouriteCommandListActivity)
                val inflater = layoutInflater
                val dialogView = inflater.inflate(R.layout.dialog_enter_command, null)
                dialogBuilder.setView(dialogView)
                var commandTitle = dialogView.findViewById<TextInputEditText>(R.id.dialog_enter_command_title_edit_text)
                var commandDescription =
                    dialogView.findViewById<TextInputEditText>(R.id.dialog_enter_command_description_edit_text)
                var saveButton = dialogView.findViewById<MaterialButton>(R.id.dialog_enter_command_save_button)

                commandTitle.setText(item.title)
                commandDescription.setText(item.description)

                commandTitle.setSelection(item.title.length)

                val alertDialog = dialogBuilder.create()
                alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                alertDialog.show()

                saveButton.setOnClickListener {
                    item.title=commandTitle.text.toString()
                    item.description=commandDescription.text.toString()
                    presenter.saveCommand(item)
                    alertDialog.dismiss()
                }
            }

        })
    }


    override fun loadDataToList(response: List<Command>?) {
        runOnUiThread {
            adapter.setData(response)
            activity_my_favourite_command_list_activity_recylerview.layoutManager =
                LinearLayoutManager(this, LinearLayout.VERTICAL, false)
            activity_my_favourite_command_list_activity_recylerview.adapter = adapter
        }



    }

}
