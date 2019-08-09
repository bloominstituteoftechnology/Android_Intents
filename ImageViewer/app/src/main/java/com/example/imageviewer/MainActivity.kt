package com.example.imageviewer

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.provider.MediaStore
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    // This array is needed to help create the UI of Images and data
    private var imageAndDataList: ArrayList<ImageData> = ArrayList()
    var imageDataIndex = 0
    var buttonIndex = 0

    companion object{
        val IMAGE_REQUEST_CODE = 3
        val STRING_REQUEST_CODE = "REQUEST_CODE"
    }


    private fun addTextToList(text: String, listIndex: Int): TextView {
        val aTextView = TextView(this)
        aTextView.width = MATCH_PARENT
        aTextView.height = 100
        aTextView.text = text
        aTextView.textSize = 16f

        aTextView.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(STRING_REQUEST_CODE, imageAndDataList[imageDataIndex-1].imageUri)
            startActivity(intent)
        }
        return aTextView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This button is set to make it possible for user to retrieve image from system
        add_image_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if(intent.resolveActivity(packageManager) != null){
                startActivityForResult(intent, IMAGE_REQUEST_CODE)
            }
        }
    }

    /*This particular lifecycle OnActivityResult takes place when the user has either retrieved
     *data or canceled that process. The process is initiated through startActivityForResult()
    */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val imageInformation = data?.data
            if(imageInformation != null) {
                scroll_list.addView(addTextToList(ImageData(imageInformation).imageUri, buttonIndex++))
                imageAndDataList.add(imageDataIndex++, ImageData(imageInformation))
                imageAndDataList[0].yeah
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
