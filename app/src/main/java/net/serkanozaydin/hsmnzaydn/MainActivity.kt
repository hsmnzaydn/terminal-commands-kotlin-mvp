package net.serkanozaydin.hsmnzaydn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var categoryRecylerviewAdapter: net.serkanozaydin.hsmnzaydn.CategoryRecylerviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


}
