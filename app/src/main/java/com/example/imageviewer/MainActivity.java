package com.example.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    public static final int IMAGE_REQUEST_CODE = 1;
    Context context;
    ImageData imageData;
    static int nextId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this; //TODO find out more on =this part

        ((Button)findViewById(R.id.main_button)).setOnClickListener(new View.OnClickListener() { //making button clickable
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT); //creating new implicit internet that grabs pic from elsewehre
                intent.setType("image/*"); //allows any type of pic
                startActivityForResult(intent, IMAGE_REQUEST_CODE); //start new activity for results TODO look up startActivityForResult for beter understanding
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_REQUEST_CODE) {   // if statement checking if result are valid the request is valid
            if (data != null) {                                               // making sure data is not null

                Uri picUri = data.getData();  //get image uri
                imageData = new ImageData(picUri, nextId++); //created new image object that hold uri and id, id increments and is used part of imageName
                ((LinearLayout)findViewById(R.id.main_linear_layout)).addView(genText(imageData.getName())); // adding textview to linear layout, call genText method and passes in imageName

            }
        }
    }

    private TextView genText(String imageName){ //parameter for image name. after image created. "saves name"
        TextView view = new TextView(context); // create new textview
        view.setText(imageName); // setting text to pic name with
        view.setPadding(15, 15, 15, 15); // density pixels
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,18); // scale pixels (text - scale to users phone)

        view.setOnClickListener(new View.OnClickListener() { //set when imageName pressed info pops up in new activity pic,uri,uri name,desc
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class); //creats new explicit intent
                intent.putExtra(Intent.EXTRA_STREAM, imageData.getUri().toString()); // TODO look up putExtra for better understanding.
                intent.putExtra(Intent.EXTRA_TEXT, imageData.getName()); // TODO
                startActivity(intent); // starts activity based on intent in para
            }
        });

        return view;
    }


}
