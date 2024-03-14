package com.example.bai1.BackgroundService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai1.databinding.ServiceActivity1Binding


class BackgroundActivity : AppCompatActivity() {
    lateinit var binding: ServiceActivity1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ServiceActivity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val i  = Intent(this, MyBackgroundService::class.java)
            startService(i)
        }
        binding.btnStop.setOnClickListener {
            val intent  = Intent(this, MyBackgroundService::class.java)
            stopService(intent)
        }
        }

}