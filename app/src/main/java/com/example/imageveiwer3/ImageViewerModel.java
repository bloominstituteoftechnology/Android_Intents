package com.example.imageveiwer3;

import android.net.Uri;

import java.io.Serializable;

public class ImageViewerModel implements Serializable {
    private String pictureUri;
    private String name;

    public ImageViewerModel(String pictureUri, String name) {
        this.pictureUri = pictureUri;
        this.name = name;
    }

    public ImageViewerModel(String pictureUri) {
        this.pictureUri = pictureUri;
    }


    public Uri getPictureUri() {
        return Uri.parse(pictureUri);
    }

    public void setPictureUri(Uri pictureUri) {
        this.pictureUri = pictureUri.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
