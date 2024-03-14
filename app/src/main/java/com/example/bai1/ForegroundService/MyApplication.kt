package com.example.bai1.ForegroundService

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApplication : Application() {
    private val CHANNEL_ID: String = "Channel_id"
    private val NAME: String = "Name"
    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationChannel: NotificationChannel
    override fun onCreate() {
        super.onCreate()
        createNotification()

    }

    private fun createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel =
                NotificationChannel(CHANNEL_ID, NAME, NotificationManager.IMPORTANCE_DEFAULT)
            notificationChannel.setSound(null,null)
            notificationManager = getSystemService(NotificationManager::class.java)
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel)
            }
        }
    }
}