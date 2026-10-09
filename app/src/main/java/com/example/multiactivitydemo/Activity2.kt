package com.example.multiactivitydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val etInput:EditText = findViewById(R.id.etInput)
        val btnReturn:Button = findViewById(R.id.btnReturn)

        btnReturn.setOnClickListener {
            val resultData = etInput.text.toString()
            val intent = Intent()
            intent.putExtra("return_data", resultData)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
