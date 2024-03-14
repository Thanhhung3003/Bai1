package com.example.bai1.ForegroundService

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class MyReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var actionMusic = intent.getIntExtra("music",0)

        val i: Intent = Intent(context, MyService::class.java)
        i.putExtra("music service",actionMusic)
        context.startService(i)
    }
}