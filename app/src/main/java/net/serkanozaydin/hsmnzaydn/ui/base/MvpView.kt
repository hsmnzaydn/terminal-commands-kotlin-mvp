package net.serkanozaydin.hsmnzaydn.ui.base

import android.app.Activity
import android.graphics.Typeface

interface MvpView {

    fun showLoading()

    fun hideLoading()


    fun showInformation(text: String)

    fun showError(text: String)

    fun hideSystemUI()

    fun getActivity(): Activity

    fun showListDialog(itemList: List<String>?, title: String, listSelectItem: ListSelectItem<Int>)
    fun showDialogWithOutChoose(
        title: String,
        description: String,
        buttonText: String,
        dialogCallback:DialogCallback
    )
}