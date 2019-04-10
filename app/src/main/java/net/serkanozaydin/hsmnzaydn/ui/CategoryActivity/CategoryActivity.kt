package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
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
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.adapters.CommandRecylerviewAdapter


class CategoryActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener,CategoryActivityMvpView,SearchView.OnQueryTextListener  {


    lateinit var adapter: CategoryRecylerviewAdapter
    lateinit var commandAdapter:CommandRecylerviewAdapter
    lateinit var changeClass: Intent


    @Inject
    lateinit var presenter: CategoryActivityMvpPresenter<CategoryActivityMvpView>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
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


        adapter= CategoryRecylerviewAdapter(object: CategoryRecylerviewAdapter.ItemListener{
            override fun onItemClick(item: Category) {
                changeClass= Intent(this@CategoryActivity, CommandListActivity::class.java)
                changeClass.putExtra(BUNDLE_CATEGORY_ID,item.id)
                startActivity(changeClass)
            }

        })

        commandAdapter= CommandRecylerviewAdapter(object : CommandRecylerviewAdapter.ItemListener{
            override fun onItemClick(item: Command) {

            }

        })



    }

    override fun loadDataToList(response: List<Category>?) {
        adapter.setData(response)
        content_navigation_recylerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        content_navigation_recylerview.adapter=adapter
    }

    override fun loadDataCommandList(commandList: List<Command>) {
        commandAdapter.setData(commandList)
        content_navigation_recylerview.adapter=commandAdapter
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
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView ??
        searchView!!.setSearchableInfo(
            searchManager.getSearchableInfo(componentName)
        )
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> return true

            else -> return super.onOptionsItemSelected(item)

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

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
        if(newText!!.length==3){
            presenter.searchInCommands(newText)
        }

        return false
    }

}
