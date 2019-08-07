package com.example.image_viewer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createTextView()
}

class ImageData (image_Uri: Uri, image_name: String): Serializable {

    private var stringUri = image_Uri.toString()
    private var image_Uri

    fun setUri(image_Uri: Uri) {
        stringUri = image_Uri.toString()
    }

    fun getUri(image_Uri: Uri) {
        image_Uri = Uri.parse(stringUri)
    }


}