package com.example.image_viewer

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    companion object {
        const val IMAGE_REQUEST_CODE = 1
        val imageUri = null
        val imageList = mutableListOf<ImageData>()
        val ImageData = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //do this 10 times with a for loop
        image_scroll_linear.addView(createTextView("", 1))

        button_add_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, IMAGE_REQUEST_CODE)
            }
        }

    }

    fun createTextView(name: String, listPositionIndex: Int): TextView {
        val textview = TextView(this)

        textview.text = name
        textview.id = listPositionIndex

        return textview

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            ImageData(imageUri = imageUri)


            imageList.add(ImageData())
            image_scroll_linear.addView(createTextView("", 1))

        }



        super.onActivityResult(requestCode, resultCode, data)
    }
}

class ImageData(imageUri: Uri) : Serializable {

    private val imageUri: Uri? = null
    private var stringUri: String = ""

    fun setName(){
        val path = stringUri.split("/".toRegex()).dropLastWhile{ it.isEmpty() }.toTypedArray()
        val name = path[path.size-1]
    }

    fun setUri(imageUri: Uri) {
        stringUri = imageUri.toString()
    }

    fun getUri():Uri {
        return Uri.parse(stringUri)
    }


}