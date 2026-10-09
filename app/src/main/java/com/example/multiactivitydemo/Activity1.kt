package com.example.multiactivitydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val tvShowMsg:TextView = findViewById(R.id.tvShowMsg)
        val msg = intent.getStringExtra("msg_key")
        tvShowMsg.text = "${getString(R.string.act1_tip)}$msg"
    }
}
