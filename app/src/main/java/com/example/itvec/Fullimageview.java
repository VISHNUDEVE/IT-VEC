package com.example.itvec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class Fullimageview extends AppCompatActivity {

    private PhotoView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimageview);

        imageView = findViewById(R.id.imageview);

        String image = getIntent().getStringExtra("image");

        Glide.with(this).load(image).into(imageView);


    }
}