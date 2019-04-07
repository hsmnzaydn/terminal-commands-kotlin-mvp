package net.serkanozaydin.hsmnzaydn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
   lateinit var datamager:DataManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MvpApp).getActivityComponent()!!.injectMainActivity(this)

        datamager.getCategories("TR",object : Callback<List<Category>>{
            override fun onSuccess(response: List<Category>?) {
                Log.d("veri","veri")
            }

            override fun onError(errorCode: Int, errorMessage: String) {
                Log.d("veri","veri")
            }

        })


    }


}
