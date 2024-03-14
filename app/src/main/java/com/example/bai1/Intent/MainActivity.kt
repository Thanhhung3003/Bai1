package com.example.bai1.Intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bai1.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btntong.setOnClickListener {
            var number1 = binding.edta.text.trim().toString()
            var number2 = binding.edtb.text.trim().toString()
            if (number1.isEmpty()|| number2.isEmpty()){
                Toast.makeText(this,"bạn nhập thiếu",Toast.LENGTH_SHORT).show()
            }
            else{
                var a: Double = binding.edta.text.toString().toDouble()
                var b: Double = binding.edtb.text.toString().toDouble()
                var sum: Double = a + b
                var i = Intent(this, ActivityIntent::class.java)
                i.putExtra("tong",sum)
                startActivity(i)
                binding.edta.setText("")
                binding.edtb.setText("")
            }

        }
    }
}