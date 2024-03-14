package com.example.bai1.BroadcastReceiver

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai1.R

class BroadcastActivity : AppCompatActivity() {
    val myBroadcast = MyBroadcast()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.broadcast_activity)


    }

    override fun onStart() {
        super.onStart()
        registerReceiver(myBroadcast, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcast)
    }
}