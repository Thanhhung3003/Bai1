package com.example.bai1.ForegroundService

import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.bai1.R


class MyService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private var ACTION_PAUSE: Int = 1
    private var ACTION_PLAY: Int = 2
    private var ACTION_CANCEL: Int = 3
    private var isCheck: Boolean ? = null
    private var mSong: Song? = null

    override fun onCreate() {
        super.onCreate()
        Log.e("Content", "onCreate Service")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val bundle: Bundle? = intent?.extras
        if (bundle != null) {
            var song: Song? = bundle.getSerializable("data") as? Song
            if (song != null) {
                mSong = song
                startMusic(song)
                sendNotification(song)
            }
        }
        var actionService = intent!!.getIntExtra("music service", 0)
        actionMusic(actionService)
        return START_STICKY
    }

    private fun startMusic(song: Song) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(applicationContext, song.file)
        }
        mediaPlayer!!.start()
        isCheck = true
    }

    private fun sendNotification(song: Song) {
        val i: Intent = Intent(this, ForegroundActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this, 0, i,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val remoteViews: RemoteViews = RemoteViews(packageName, R.layout.customnotification)
        remoteViews.setTextViewText(R.id.textTitle, song.tenBai)
        remoteViews.setTextViewText(R.id.textContent, song.caSi)
        remoteViews.setImageViewResource(R.id.imgsong, R.drawable.notifications_icon)
        remoteViews.setImageViewResource(R.id.imgplay, R.drawable.play)
        remoteViews.setImageViewResource(R.id.imgexit, R.drawable.cancel)
        if (isCheck == true) {
            remoteViews.setOnClickPendingIntent(R.id.imgplay, getPendingIntent(this, ACTION_PAUSE))
        } else {
            remoteViews.setOnClickPendingIntent(R.id.imgplay, getPendingIntent(this, ACTION_PLAY))
        }
        remoteViews.setOnClickPendingIntent(R.id.imgexit, getPendingIntent(this, ACTION_CANCEL))

        val notification = NotificationCompat.Builder(this, "Channel_id")
            .setSmallIcon(R.drawable.notifications_icon)
            .setContentIntent(pendingIntent)
            .setCustomContentView(remoteViews)
            .setSound(null)
            .build()
        startForeground(1, notification)
    }

    private fun getPendingIntent(context: Context, action: Int): PendingIntent {
        val intent = Intent(this, MyService::class.java)
        intent.putExtra("music service", action)
        return PendingIntent.getService(context.applicationContext, action, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Content", "Stop Service")
        mediaPlayer!!.release()
        mediaPlayer = null
    }

    private fun actionMusic(action: Int) {
        when (action) {
            ACTION_PAUSE -> actionPause()
            ACTION_PLAY -> actionPlay()
            ACTION_CANCEL -> stopSelf()
        }
    }

    private fun actionPlay() {
        if (mediaPlayer != null && isCheck == false && mSong != null) {
            mediaPlayer!!.start()
            isCheck = true
            sendNotification(mSong!!)
        }

    }

    private fun actionPause() {
        if (mediaPlayer != null && isCheck == true && mSong != null) {
            mediaPlayer!!.pause()
            isCheck = false
            sendNotification(mSong!!)
        }

    }
}
