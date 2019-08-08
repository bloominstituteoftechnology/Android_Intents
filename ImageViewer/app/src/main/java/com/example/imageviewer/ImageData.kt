package com.example.imageviewer

import android.net.Uri
import java.io.Serializable

class ImageData(imageUri : Uri) : Serializable {
    var imageUri = imageUri.toString()
        private set

}