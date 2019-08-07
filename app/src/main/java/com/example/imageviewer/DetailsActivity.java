package com.example.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity implements Serializable {

    Context context;
    ImageView iVHandler;
    TextView uriHandler;
    TextView inameHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        context = this;
        iVHandler = findViewById(R.id.picImage); //attacthing imageview to handler

        Intent intent = getIntent(); //retrieving an intent
        final Uri storeImage = Uri.parse(intent.getStringExtra(Intent.EXTRA_STREAM));  // retriving image uri. was txt. convert back to uri to display TODO getStringExtra

        iVHandler.setImageURI(storeImage);

        iVHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullscreenActivity.class);
                intent.putExtra(Intent.EXTRA_STREAM, storeImage.toString());
                startActivity(intent);
            }
        });

        uriHandler = findViewById(R.id.view_image_uri);
        uriHandler.setText(storeImage.toString());

        inameHandler = findViewById(R.id.view_image_name);
        inameHandler.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
    }

}
