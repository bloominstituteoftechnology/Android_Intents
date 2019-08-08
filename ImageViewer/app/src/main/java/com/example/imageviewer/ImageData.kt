package com.example.imageviewer

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.ParcelFileDescriptor
import java.io.FileDescriptor
import java.io.Serializable

class ImageData(imageUri : Uri) : Serializable {
    var imageUri = imageUri.toString()

    val parcelFileDescriptor: ParcelFileDescriptor = contentResolver.openFileDescriptor(imageUri, "r")
    val fileDescriptor: FileDescriptor = parcelFileDescriptor.fileDescriptor
    val image: Bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor)
    parcelFileDescriptor.close()
}