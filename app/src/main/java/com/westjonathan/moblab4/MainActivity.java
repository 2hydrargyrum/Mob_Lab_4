package com.westjonathan.moblab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    ViewFlipper vflip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         vflip = findViewById(R.id.viewFlipito);
//        // you can switch between next and previous layout and display it
//        vflip.showNext();
//        vflip.showPrevious();
//        // or you can switch selecting the layout that you want to display
//        vflip.setDisplayedChild(1);
//        vflip.setDisplayedChild(vflip.indexOfChild(findViewById(R.id.secondLayout);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                //detect horizontal swipes:
                float deltaX = x2 - x1;
                if (Math.abs(deltaX) > MIN_DISTANCE && deltaX > 0) {
//                    Toast.makeText(this, "left2right swipe", Toast.LENGTH_SHORT).show ();
                    vflip.showPrevious();
                }
                else if(Math.abs(deltaX) > MIN_DISTANCE) { // deltaX < 0
//                    Toast.makeText(this, "right2left swipe", Toast.LENGTH_SHORT).show ();
                    vflip.showNext();
                }
                else { // not horizontal swipe
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}