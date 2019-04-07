package net.serkanozaydin.hsmnzaydn.ui.CategoryActivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import net.serkanozaydin.hsmnzaydn.MvpApp
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.Utility.BUNDLE_CATEGORY_ID
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.ui.CommandListActivity.CommandListActivity
import net.serkanozaydin.hsmnzaydn.ui.adapters.CategoryRecylerviewAdapter
import net.serkanozaydin.hsmnzaydn.ui.base.BaseActivity
import javax.inject.Inject

class CategoryActivity : BaseActivity(),CategoryActivityMvpView {

    lateinit var adapter:CategoryRecylerviewAdapter
    lateinit var changeClass:Intent


    @Inject
    lateinit var presenter: CategoryActivityMvpPresenter<CategoryActivityMvpView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MvpApp).getActivityComponent()!!.injectMainActivity(this)

        presenter.onAttach(this)
        presenter.getCategories()


        adapter= CategoryRecylerviewAdapter(object: CategoryRecylerviewAdapter.ItemListener{
            override fun onItemClick(item: Category) {
                changeClass= Intent(this@CategoryActivity,CommandListActivity::class.java)
                changeClass.putExtra(BUNDLE_CATEGORY_ID,item.id)
                startActivity(changeClass)
            }

        })
    }


    override fun loadDataToList(response: List<Category>?) {
        adapter.setData(response)
        activity_main_recyler_view.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        activity_main_recyler_view.adapter=adapter
    }

}
