package com.example.rent.myapplication.Fortune;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;

import com.example.rent.myapplication.R;
import com.squareup.seismic.ShakeDetector;

import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class FortuneActivity extends AppCompatActivity implements ShakeDetector.Listener {

    private FrameLayout layer;
    private Random random;
    private Animator animation;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector shake = new ShakeDetector(this);
        shake.start(sensorManager);

        final FrameLayout layer = (FrameLayout) findViewById(R.id.fortune_container);

        FrameLayout parentLayout = (FrameLayout) findViewById(R.id.parent_layout);

        parentLayout.setOnTouchListener(new View.OnTouchListener() {


            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    CircularReveal((int) event.getX(), (int) event.getY(), layer);
                }
                return true;
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void hearShake() {
        int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt());
        layer.setBackgroundColor(color);
        CircularReveal(random.nextInt(layer.getWidth()), random.nextInt(layer.getHeight()), layer);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void CircularReveal(int x, int y, final FrameLayout layer) {
        if (layer.getVisibility() == View.VISIBLE) {
            Animator circularReveal = ViewAnimationUtils
                    .createCircularReveal(layer, x, y, layer.getHeight(), 0);
            layer.setVisibility(View.INVISIBLE);

            circularReveal.addListener(new AnimatorListenerAdapter() {
                                           public void onAnimationEnd(Animator animation) {
//                lambda
                                               layer.setVisibility(View.INVISIBLE);
                                           }
                                       });
                circularReveal.start();

        } else {
            int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
            layer.setBackgroundColor(color);
            Animator circularReveal = ViewAnimationUtils
                    .createCircularReveal(layer, x, y, 0, layer.getHeight());
            layer.setVisibility(View.VISIBLE);
            circularReveal.start();
        }
    }

    private void onAnimationEnd(Animator animation) {
    }
}