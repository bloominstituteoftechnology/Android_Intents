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


class MainActivity : AppCompatActivity() {
    // This array is needed to help create the UI of Images and data
    private var imageAndDataList: ArrayList<ImageData> = ArrayList()
    // This array is going to hold the TextViews for the UI
    private var imageNames: ArrayList<TextView> = ArrayList()

    companion object{
        val IMAGE_REQUEST_CODE = 3
    }


//    <TextView
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:text="Beautiful Ocean"
//    android:textSize="18dp"
//    android:paddingLeft="2dp"
//    />

    private fun addTextToList(text: String/*, listIndex: Int*/): TextView {
        val aTextView = TextView(this)
        aTextView.width = MATCH_PARENT
        aTextView.height = WRAP_CONTENT
        aTextView.text = text
        aTextView.textSize = 16f
        imageNames.add(aTextView)
        return aTextView
    }

//    <ImageView
//    android:layout_width="match_parent"
//    android:layout_height="80dp"
//    android:scaleType="centerCrop"
//    android:adjustViewBounds="false"
//    />

    private fun addImageToList(image: Bitmap): ImageView {
        val view = ImageView(this)
        view.setImageBitmap(image)
        view.scaleType = ImageView.ScaleType.CENTER_CROP
        view.adjustViewBounds = false
        view.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, 160)
        return view
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
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageInformation)
                //scroll_list.addView(addImageToList(bitmap))
                scroll_list.addView(addTextToList("What I want"))
            }
                //.setImageBitmap(BitmapFactory.decodeFile(imageInformation))
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
