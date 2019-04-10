package net.serkanozaydin.hsmnzaydn.ui.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.Utility.showLoadingDialog

abstract class BaseActivity : AppCompatActivity(), MvpView {

    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun showLoading() {
        progressDialog = showLoadingDialog(this@BaseActivity)
    }

    override fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog.isShowing) {
                progressDialog.dismiss()

            }
        }
    }

    override fun getActivity(): Activity {
        return this@BaseActivity
    }


    override fun showInformation(text: String) {
        Toast.makeText(this@BaseActivity, text, Toast.LENGTH_SHORT).show()
    }

    override fun showError(text: String) {
        Toast.makeText(this@BaseActivity, text, Toast.LENGTH_SHORT).show()
    }

    override fun hideSystemUI() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE

                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return false
    }


}