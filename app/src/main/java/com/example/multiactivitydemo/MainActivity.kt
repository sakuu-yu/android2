package com.example.multiactivitydemo

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvReceive: TextView

    // 接收Activity2返回数据
    private val act2Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK){
            val returnStr = result.data?.getStringExtra("return_data")
            tvReceive.text = "${getString(R.string.main_receive_tip)}$returnStr"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvReceive = findViewById(R.id.tvReceive)
        val btnGoAct1:Button = findViewById(R.id.btnGoAct1)
        val btnGoAct2:Button = findViewById(R.id.btnGoAct2)
        val btnGoAct3:Button = findViewById(R.id.btnGoAct3)
        val btnGoAct4:Button = findViewById(R.id.btnGoAct4)

        // 跳转Activity1，正向传参
        btnGoAct1.setOnClickListener {
            val intent = Intent(this, Activity1::class.java)
            intent.putExtra("msg_key", "伍思成_2024110538")
            startActivity(intent)
        }

        // 跳转Activity2，等待返回数据
        btnGoAct2.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            act2Launcher.launch(intent)
        }

        // 跳转Activity3 拍照
        btnGoAct3.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }

        // 跳转Activity4 秒表
        btnGoAct4.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }
    }
}
