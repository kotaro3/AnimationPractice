package com.example.kotaro.animationpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity{

    public void onClickButton(View v) {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.dragText);
        Button btn = (Button)findViewById(R.id.btn1);
        DragViewListener dragListner = new DragViewListener(textView,btn,this);
        textView.setOnTouchListener(dragListner);
    }
}
