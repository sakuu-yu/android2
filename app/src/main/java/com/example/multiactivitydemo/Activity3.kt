package com.example.multiactivitydemo

import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Activity3 : AppCompatActivity() {
    private lateinit var ivPhoto: ImageView

    private val takePhotoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val bundle = result.data?.extras
            val bitmap = bundle?.get("data") as? Bitmap
            bitmap?.let {
                ivPhoto.setImageBitmap(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val btnTakePhoto: Button = findViewById(R.id.btnTakePhoto)
        ivPhoto = findViewById(R.id.ivPhoto)

        btnTakePhoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePhotoLauncher.launch(intent)
        }
    }
}
