package com.kewenc.kewencmvc.controller;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.kewenc.kewencmvc.R;
import com.kewenc.kewencmvc.model.Model;

public class MainActivity extends AppCompatActivity implements Model.OnStateChangeListener{

    private Model model;
    private ImageView ig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new Model(this);
        model.setOnStateChangedListener(this);
        ig = findViewById(R.id.ig);
        ig.setImageBitmap(model.getBitmap());
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                model.loadImage();
                break;
        }
    }

    @Override
    public void onStateChanged(Bitmap bitmap) {
        ig.setImageBitmap(bitmap);
    }
}
