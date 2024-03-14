package com.example.bai1.BoundService

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyBoundService: Service() {

    private var myBinder = CalculatorBinder()
    var a : Int = 0
    var b : Int = 0
    fun calculateSum(): Int {
        return a + b
    }
    inner class CalculatorBinder : Binder() {
        fun getService(): MyBoundService {
            return this@MyBoundService
        }


    }

    override fun onBind(p0: Intent?): IBinder? {
        return myBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("onUnbind","done")
        return super.onUnbind(intent)
    }
    override fun onCreate() {
        super.onCreate()
        Log.e("onCreate","done")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy","done")
    }


}