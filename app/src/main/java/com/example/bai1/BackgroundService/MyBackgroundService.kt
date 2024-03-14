package com.example.bai1.BackgroundService

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.example.bai1.R


class MyBackgroundService: Service()  {
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate() {
        super.onCreate()
        Log.e("Content", "onCreate Service")
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.a)
        }
        mediaPlayer!!.start()
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Content", "Stop Service")
        mediaPlayer!!.stop()
        mediaPlayer!!.release()
        mediaPlayer = null

    }
}