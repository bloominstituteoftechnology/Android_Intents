package com.example.imageviewer

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        public val IMG_CODE = 6
    }

    val list = ArrayList<ImageData>()

    fun createTextView(text: String?, index: Int): TextView {
        val displayText = TextView(this)
        displayText.text = text
        displayText.textSize = 32f
        displayText.textAlignment = View.TEXT_ALIGNMENT_CENTER
        displayText.setOnClickListener{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("key", list[index])
            startActivity(intent)
        }

        return displayText

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            if(intent.resolveActivity(packageManager) != null){
                startActivityForResult(intent, IMG_CODE)
            }
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == IMG_CODE && resultCode == Activity.RESULT_OK){
            val image = data?.data
            list.add(ImageData(image))
            println(image)
            scroll_layout.addView(createTextView(ImageData(image).setUriPath(image), list.size - 1))
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}
