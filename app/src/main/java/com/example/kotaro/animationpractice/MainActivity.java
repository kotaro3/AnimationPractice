package com.example.kotaro.animationpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = (TextView)findViewById(R.id.dragText);
        Button btn = (Button)findViewById(R.id.btn1);
        ImageView image1 = (ImageView)findViewById(R.id.image1);
        ImageView image2 = (ImageView)findViewById(R.id.image2);
        ImageView image3 = (ImageView)findViewById(R.id.image3);
        ImageView image4 = (ImageView)findViewById(R.id.image4);
        ImageView image5 = (ImageView)findViewById(R.id.image5);

        ArrayList<ImageView> images = new ArrayList<>();
        images.add(image1);
        images.add(image1);
        images.add(image1);
        images.add(image1);
        images.add(image1);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.test_animation);
        image1.startAnimation(anim);
        image2.startAnimation(anim);
        image3.startAnimation(anim);
        image4.startAnimation(anim);
        image5.startAnimation(anim);

        DragViewListener dragListner = new DragViewListener(this,btn);
        textView.setOnTouchListener(dragListner);
        image1.setOnTouchListener(dragListner);
        image2.setOnTouchListener(dragListner);
        image3.setOnTouchListener(dragListner);
        image4.setOnTouchListener(dragListner);
        image5.setOnTouchListener(dragListner);

    }
}
