package zup.pocandroid.util

import android.content.Context
import android.support.v7.app.AlertDialog

fun showAlertMessage(context: Context, message: String) {
    AlertDialog.Builder(context)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }.show()
}