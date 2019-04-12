package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import android.app.AlertDialog
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.content_navigation.*
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.Utility.BUNDLE_CATEGORY_ID
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.ui.CommandListActivity.CommandListActivity
import net.serkanozaydin.hsmnzaydn.ui.adapters.CategoryRecylerviewAdapter
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import javax.inject.Inject
import net.serkanozaydin.hsmnzaydn.R

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import net.ozaydin.serkan.easy_csv.EasyCsv
import net.ozaydin.serkan.easy_csv.FileCallback
import net.serkanozaydin.hsmnzaydn.Utility.BUNDLE_CATEGORY_NAME
import net.serkanozaydin.hsmnzaydn.Utility.shareFile
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity.MyFavouriteCommandListActivity
import net.serkanozaydin.hsmnzaydn.ui.ShareCommandsActivity.ShareCommandsActivity
import net.serkanozaydin.hsmnzaydn.ui.adapters.CommandRecylerviewAdapter
import java.io.File


class CategoryActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, CategoryActivityMvpView,
    SearchView.OnQueryTextListener {


    lateinit var adapter: CategoryRecylerviewAdapter
    lateinit var commandAdapter: CommandRecylerviewAdapter
    lateinit var changeClass: Intent


    @Inject
    lateinit var presenter: CategoryActivityMvpPresenter<CategoryActivityMvpView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val dialogBuilder = AlertDialog.Builder(this@CategoryActivity)
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_enter_command, null)
            dialogBuilder.setView(dialogView)
            var commandTitle = dialogView.findViewById<TextInputEditText>(R.id.dialog_enter_command_title_edit_text)
            var commandDescription =
                dialogView.findViewById<TextInputEditText>(R.id.dialog_enter_command_description_edit_text)
            var saveButton = dialogView.findViewById<MaterialButton>(R.id.dialog_enter_command_save_button)



            val alertDialog = dialogBuilder.create()
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            alertDialog.show()

            saveButton.setOnClickListener {
                presenter.saveCommand(commandTitle.text.toString(),commandDescription.text.toString())
                alertDialog.dismiss()
            }



        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        (application as MvpApp).getActivityComponent()!!.injectMainActivity(this)

        presenter.onAttach(this)
        presenter.getCategories()


        adapter = CategoryRecylerviewAdapter(object : CategoryRecylerviewAdapter.ItemListener {
            override fun onItemClick(item: Category) {
                changeClass = Intent(this@CategoryActivity, CommandListActivity::class.java)
                changeClass.putExtra(BUNDLE_CATEGORY_ID, item.id)
                changeClass.putExtra(BUNDLE_CATEGORY_NAME, item.title)
                startActivity(changeClass)
            }

        })

        commandAdapter = CommandRecylerviewAdapter(object : CommandRecylerviewAdapter.ItemListener {
            override fun onItemClick(item: Command) {

            }

        })


    }

    override fun loadDataToList(response: List<Category>?) {
        adapter.setData(response)
        content_navigation_recylerview.layoutManager =
            LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        content_navigation_recylerview.adapter = adapter
    }

    override fun loadDataCommandList(commandList: List<Command>) {
        commandAdapter.setData(commandList)
        content_navigation_recylerview.adapter = commandAdapter
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        // Associate searchable configuration with the SearchView


        menuInflater.inflate(R.menu.navigation, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView??
        searchView!!.setSearchableInfo(
            searchManager.getSearchableInfo(componentName)
        )
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> {
                presenter.showLanguageDialog()
                return true
            }

            else -> return super.onOptionsItemSelected(item)

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                var intent=Intent(this@CategoryActivity,MyFavouriteCommandListActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_gallery -> {
                var intent=Intent(this@CategoryActivity,ShareCommandsActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText!!.length == 3) {
            presenter.searchInCommands(newText)
        } else if (newText!!.length < 2) {
            presenter.getCategories()
        } else if (newText.length > 3) {
            presenter.filterInCommandList(newText)
        }

        return false
    }

}
