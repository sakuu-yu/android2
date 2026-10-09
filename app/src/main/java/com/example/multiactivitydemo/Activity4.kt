package com.example.multiactivitydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class Activity4 : AppCompatActivity() {
    private lateinit var tvTime: TextView
    private lateinit var btnStart: Button
    private lateinit var btnPause: Button
    private lateinit var btnReset: Button

    private var time = 0L
    private var isRunning = false
    private val handler = Handler(Looper.getMainLooper())

    private val runnable = object : Runnable {
        override fun run() {
            time++
            val h = time / 3600
            val m = (time % 3600) / 60
            val s = time % 60
            tvTime.text = String.format("%02d:%02d:%02d", h, m, s)
            handler.postDelayed(this,1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)
        tvTime = findViewById(R.id.tvTime)
        btnStart = findViewById(R.id.btnStart)
        btnPause = findViewById(R.id.btnPause)
        btnReset = findViewById(R.id.btnReset)

        btnStart.setOnClickListener {
            if(!isRunning){
                isRunning = true
                handler.post(runnable)
            }
        }

        btnPause.setOnClickListener {
            isRunning = false
            handler.removeCallbacks(runnable)
        }

        btnReset.setOnClickListener {
            isRunning = false
            handler.removeCallbacks(runnable)
            time = 0
            tvTime.text = "00:00:00"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}
