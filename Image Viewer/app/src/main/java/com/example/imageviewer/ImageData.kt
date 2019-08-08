package com.example.imageviewer

import android.net.Uri
import java.io.Serializable


class ImageData : Serializable  {

    private var uri: String? = null
    private var name:String? = null
    private var id: Int = 0

    fun ImageData(uri: Uri, id: Int) {
        this.uri = uri.toString()
        this.id = id
        this.name = "Image$id"
    }

    fun ImageData(Uri: String, name: String) {
        this.uri = Uri
        this.name = name
    }

    fun getUri(): Uri {
        return Uri.parse(uri)
    }

    fun setUri(uri: Uri) {
        this.uri = uri.toString()
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

}
