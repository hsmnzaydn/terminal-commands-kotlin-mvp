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
import androidx.appcompat.app.AlertDialog
import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.Utility.showLoadingDialog

abstract class BaseActivity : AppCompatActivity(), MvpView {

    lateinit var progressDialog: ProgressDialog
    private var alertDialogBuilder: AlertDialog.Builder? = null

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

    override fun showListDialog(itemList: List<String>?, title: String, listSelectItem: ListSelectItem<Int>) {

        if (itemList != null) {
            val builder = androidx.appcompat.app.AlertDialog.Builder(this@BaseActivity)
            builder.setTitle(title)


           var stockArr = itemList.toTypedArray<String>()

            builder.setItems(
                stockArr
            ) { dialog, which -> listSelectItem.selectedItem(which) }

            val dialog = builder.create()
            dialog.show()
        }
    }

    override fun showDialogWithOutChoose(
        title: String,
        description: String,
        buttonText: String,
        dialogCallback: DialogCallback
    ) {
        alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder!!.setTitle(title).setMessage(description).setPositiveButton(buttonText,
            DialogInterface.OnClickListener { dialog, which -> dialogCallback.pressedPossitiveButton() })
        val alertDialog = alertDialogBuilder!!.create()

        alertDialog.setOnShowListener(DialogInterface.OnShowListener {
            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(R.color.colorPrimaryDark))
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.colorPrimaryDark))
        })

        alertDialog.setCanceledOnTouchOutside(true)
        alertDialog.show()

    }

}