package net.serkanozaydin.hsmnzaydn.Utility

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.StrictMode
import android.widget.ProgressBar
import net.serkanozaydin.hsmnzaydn.R
import java.io.File


fun showLoadingDialog(context: Context): ProgressDialog {
    var progressDialog: ProgressDialog = ProgressDialog(context)
    if (!(context as Activity).isFinishing) {
        progressDialog.show()
    }
    if (progressDialog.window != null) {
        progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    progressDialog.setContentView(R.layout.progress_dialog)
    progressDialog.isIndeterminate = true
    progressDialog.setCancelable(false)
    progressDialog.setCanceledOnTouchOutside(false)
    return progressDialog
}

fun shareFile(file: File, activity: Activity) {
    val builder = StrictMode.VmPolicy.Builder()
    StrictMode.setVmPolicy(builder.build())

    val intentShareFile = Intent(Intent.ACTION_SEND)
    val fileWithinMyDir = File(file.path)

    if (fileWithinMyDir.exists()) {
        intentShareFile.type = "application/octet-stream"
        intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + file.path))


        activity.startActivity(Intent.createChooser(intentShareFile, "Paylaş"))
    }
}