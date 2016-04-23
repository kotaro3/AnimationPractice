package com.example.kotaro.animationpractice;

import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kotaro on 2016/04/19.
 */
public class DragViewListener implements View.OnTouchListener {

    private TextView textView;
    private MainActivity activity;
    private Button btn;
    private int oldx;
    private int oldy;

    public DragViewListener(TextView textView,Button btn,MainActivity activity){
        this.textView = textView;
        this.activity = activity;
        this.btn = btn;
    }

    public void onClickButton(View v) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // 今回イベントでのView移動先の位置
                int left = textView.getLeft() + (x - oldx);
                int top = textView.getTop() + (y - oldy);
                // Viewを移動する
                textView.layout(left, top, left + textView.getWidth(), top + textView.getHeight());
                Log.v("TouchEvent","MOVE");
                break;
            case MotionEvent.ACTION_DOWN:
                oldx = x;
                oldy = y;
                Log.v("TouchEvent","DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.v("TouchEvent","UP");
                int[] offset = new int[2];
                btn.getLocationOnScreen(offset);
                Rect rect = new Rect();

                btn.getHitRect(rect);
                rect.offset(offset[0], offset[1]);

                if (rect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    btn.performClick();
                    onClickButton(btn);
                }
                break;
        }

        // 今回のタッチ位置を保持
        oldx = x;
        oldy = y;
        // イベント処理完了
        return true;
    }

}
