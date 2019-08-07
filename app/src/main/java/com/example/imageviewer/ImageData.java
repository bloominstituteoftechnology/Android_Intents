package com.example.imageviewer;

import android.net.Uri;
import java.io.Serializable;


public class ImageData implements Serializable {
    private String uri, name;
    private int id;

    public ImageData(Uri uri, int id){
        this.uri = uri.toString();
        this.id = id;
        this.name = "Image" +id;
    }



    public ImageData(String Uri, String name) {
        this.uri = Uri;
        this.name = name;
    }

    public Uri getUri() {
        return Uri.parse(uri);
    }

    public void setUri(Uri uri) {
        this.uri = uri.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
