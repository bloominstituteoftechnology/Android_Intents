package com.example.imageviewer

import android.net.Uri
import java.io.Serializable

class ImageData(uriPhoto: Uri?): Serializable {
    var description: String? = null
    var uriToString: String? = null


    fun getUriPath(): Uri {
        return Uri.parse(uriToString)
    }

    fun setUriPath(uri: Uri?): String? {
        uriToString = uri.toString()
        return uriToString
    }


}