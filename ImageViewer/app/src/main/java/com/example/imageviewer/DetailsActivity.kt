package com.example.imageviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.core.net.toUri
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val stringData: String = intent.getStringExtra(MainActivity.STRING_REQUEST_CODE) ?: "No Data"
        text_view.text = stringData
        text_view.textSize = 16f

        image_view.setImageURI(stringData.toUri())
        // this stuff below is the hard way to set an image haha
        //val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, stringData.toUri())
        //image_view.setImageBitmap(bitmap)

        //var myObject = intent.getSerializableExtra(MainActivity.STRING_REQUEST_CODE) as ImageData

        image_view.setOnClickListener {

        }
    }
}
