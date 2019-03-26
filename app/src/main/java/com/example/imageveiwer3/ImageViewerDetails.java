package com.example.imageveiwer3;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ImageViewerDetails extends AppCompatActivity {

    TextView imageDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer_details);

        imageDetails = findViewById(R.id.details_of_image);
        ImageView receivedImage = findViewById(R.id.received_image);

        Intent getImage = getIntent();
        ImageViewerModel imageViewerModel = (ImageViewerModel) getImage.getSerializableExtra("sentImage");
        receivedImage.setImageURI(imageViewerModel.getPictureUri());



    }
}
