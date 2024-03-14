package com.example.bai1.BoundService

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.bai1.databinding.BoundActivityBinding


class BoundActivity : AppCompatActivity() {
    private var isCheck = false
    private var myBoundService: MyBoundService? = null
    private val serviceConnection = object :ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
           var myBinder :  MyBoundService.CalculatorBinder = service as MyBoundService.CalculatorBinder
            myBoundService = myBinder.getService()
            isCheck = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isCheck = false
        }

    }

    private lateinit var binding: BoundActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BoundActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            clickStartSevice()
        }
        binding.btnStop.setOnClickListener {
            clickStopSevice()
        }
        binding.btnResult.setOnClickListener {
            if (isCheck){
                var numberA : Int = binding.edtA.text.toString().toInt()
                var numberB : Int = binding.edtB.text.toString().toInt()
                myBoundService!!.a = numberA
                myBoundService!!.b = numberB
                val result = myBoundService!!.calculateSum()
                binding.tvKQ.text = result.toString()

            }

        }
    }

    private fun clickStopSevice() {
        if(isCheck){
            unbindService(serviceConnection)
            isCheck = false
        }
    }

    private fun clickStartSevice() {
        val i: Intent = Intent(this,MyBoundService::class.java)
        bindService(i,serviceConnection,Context.BIND_AUTO_CREATE)
    }


}
