package com.example.imageveiwer3;

        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ImageViewerDetails extends AppCompatActivity {

    Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer_details);

        TextView imageDetails = findViewById(R.id.details_of_image);
        ImageView receivedImage = findViewById(R.id.received_image);




        Intent getImage = getIntent();
        final ImageViewerModel imageViewerModel = (ImageViewerModel) getImage.getSerializableExtra("sentImage");
        receivedImage.setImageURI(imageViewerModel.getPictureUri());

        imageDetails.setText(imageViewerModel.getName());

        receivedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sentImage = new  Intent(context,FullscreenActivity.class);
                sentImage.putExtra("sentImage",imageViewerModel);
                startActivity(sentImage);


            }
        });





    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityLifecycle",getLocalClassName() +  " - onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityLifecycle",getLocalClassName() +  " - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityLifecycle",getLocalClassName() +  " - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityLifecycle",getLocalClassName() +  " - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityLifecycle",getLocalClassName() +  " - onDestroy");
    }
}
