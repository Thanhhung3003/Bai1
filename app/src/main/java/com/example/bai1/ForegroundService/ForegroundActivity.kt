package com.example.bai1.ForegroundService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai1.databinding.BackgroundActivityBinding
import com.example.bai1.R



class ForegroundActivity : AppCompatActivity() {
    private lateinit var binding: BackgroundActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BackgroundActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnstartMusic.setOnClickListener {
            ClickStartMusic()

        }
        binding.btnstopMusic.setOnClickListener {
            ClickStopmusic()
        }
    }

    private fun ClickStopmusic() {
        val intent : Intent = Intent(this, MyService::class.java)
        stopService(intent)
    }

    private fun ClickStartMusic() {
        val i: Intent = Intent(this,MyService::class.java)
        val song : Song = Song("Em","jack", R.drawable.notifications_icon,R.raw.a)
        val bundle: Bundle = Bundle()
        bundle.putSerializable("data",song)
        i.putExtras(bundle)
        startForegroundService(i)

    }

}