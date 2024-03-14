package com.example.bai1.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bai1.R

class ActivityIntent: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_intent)
        var btnBack : Button = findViewById(R.id.btnback)
        var kq = findViewById<TextView>(R.id.tong)
        var i = intent
        var tong: Double = i.getDoubleExtra("tong",0.0)
        kq.text = ""+ tong
        btnBack.setOnClickListener {
            finish()
        }
    }
}