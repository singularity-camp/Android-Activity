package kz.singularity.activity1

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import timber.log.Timber

const val EXTRA_NOTIFICATION_ID = "NOTIFICATION_ID"

class CustomActionBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Timber.e("OnReceive")
        Toast.makeText(context, "CustomActionBroadCastReceiver called", Toast.LENGTH_SHORT).show()
        val notificationId = intent.getIntExtra(EXTRA_NOTIFICATION_ID, 0)

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(notificationId)
    }
}