package com.felece.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.felece.kotlin.data.Callback
import com.felece.kotlin.data.DataManagerImp
import com.felece.kotlin.data.entity.Category
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var categoryRecylerviewAdapter: CategoryRecylerviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


}
