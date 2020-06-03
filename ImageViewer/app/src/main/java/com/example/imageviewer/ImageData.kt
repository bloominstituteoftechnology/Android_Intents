package com.example.imageviewer

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.ParcelFileDescriptor
import androidx.core.net.toUri
import java.io.FileDescriptor
import java.io.Serializable

class ImageData(imageUri : Uri) : Serializable {
    var imageUri = imageUri.toString()
}