package com.wangban.yzbbanban.fram_anim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by YZBbanban on 16/6/24.
 */
public class MyView extends View {
    private int textX = 20, textY = 20;

    public MyView(Context context) {
        super(context);
        setFocusable(true);
 //       setFocusableInTouchMode(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        paint.setColor(Color.RED);
        paint.setTextSize(50.0f);
        canvas.drawText("game", textX, textY, paint);

        super.onDraw(canvas);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            //“上”按键被点击，应该让文本的Y坐标变小
            textY -= 5;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            //“下”按键被点击，应该让文本的Y坐标变大
            textY += 5;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            //“左”按键被点击，应该让文本的X坐标变小
            textX -= 5;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            //“右”按键被点击，应该让文本的X坐标变大
            textX += 5;
        }
        invalidate();

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        return super.onKeyUp(keyCode, event);
    }

    //    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                textX = x;
//                textY = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                textX = x;
//                textY = y;
//                break;
//            case MotionEvent.ACTION_UP:
//                textX = x;
//                textY = y;
//                break;
//        }
//        invalidate();
//
//        return true;
//    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取用户手指触屏的X坐标赋值与文本的X坐标
        textX = (int) event.getX();
        //获取用户手指触屏的Y坐标赋值与文本的Y坐标
        textY = (int) event.getY();
        //重绘画布
        invalidate();
        //postInvalidate();
        return true;
    }
}
