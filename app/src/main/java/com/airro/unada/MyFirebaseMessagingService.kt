package com.airro.unada

import android.app.NotificationChannel
import android.app.NotificationManager
import android.preference.PreferenceManager
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        val notificationsEnabled = sharedPrefs.getBoolean("notificationsEnabled", true)

        if (notificationsEnabled) {
            val name = "채팅 알림"
            val descriptionText = "채팅 알림입니다."
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(
                getString(R.string.default_notification_channel_id),
                name,
                importance
            )
            mChannel.description = descriptionText
            val notificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)

            val title = message.notification?.title ?: ""
            val body = message.notification?.body ?: ""
            val notificationBuilder = NotificationCompat.Builder(applicationContext, getString(R.string.default_notification_channel_id))
                .setSmallIcon(R.drawable.heart)
                .setContentTitle(title)
                .setContentText(body)

            notificationManager.notify(0, notificationBuilder.build())
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }
}
