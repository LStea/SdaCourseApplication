package com.example.rent.myapplication.SpeedTest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rent.myapplication.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SpeedTestActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Integer> images = Arrays.asList(R.drawable.one, R.drawable.two,
            R.drawable.three, R.drawable.four, R.drawable.five);

    private Random random = new Random();
    private ImageView firstImageView;
    private ImageView secondImageView;
    private Button firstPlayerButton;
    private Button secondPlayerButton;
    private Button startButton;
    private TextView introTextView;
    private CountDownTimer countDownTimer;
    private boolean isRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_test);

        firstImageView = (ImageView) findViewById(R.id.first_image_view);
        secondImageView = (ImageView) findViewById(R.id.second_image_view);
        startButton = (Button) findViewById(R.id.start_button);
        introTextView = (TextView) findViewById(R.id.intro_text_view);
        firstPlayerButton = (Button) findViewById(R.id.user1);
        secondPlayerButton = (Button) findViewById(R.id.user2);
        firstPlayerButton.setOnClickListener(this);
        secondPlayerButton.setOnClickListener(this);


        countDownTimer = new CountDownTimer(20000, 500) {

            @Override
            public void onTick(long millisUntilFinished) {
                int firstImage = images.get(random.nextInt(images.size()));
                int secondImage = images.get(random.nextInt(images.size()));

                firstImageView.setImageResource(firstImage);
                firstImageView.setTag(firstImage);
                secondImageView.setImageResource(secondImage);
                secondImageView.setTag(secondImage);
            }

            @Override
            public void onFinish() {
                isRunning = false;
                startButton.setVisibility(View.VISIBLE);
            }
        };


        startButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateCounter(introTextView, new Runnable() {
                    @Override
                    public void run() {
                        isRunning = true;
                        firstImageView.setVisibility(View.VISIBLE);
                        secondImageView.setVisibility(View.VISIBLE);
                        countDownTimer.start();
                    }
                }, 3);

                startButton.setVisibility(View.GONE);
            }
        }));

//        random.nextInt(images.size());


    }

    private void animateCounter(final TextView introTextView, final Runnable animationsEnd, final int counter) {
        String text = counter == 0 ? "START" : String.valueOf(counter);

        introTextView.setText(text);
        introTextView.setAlpha(1);
        introTextView.setScaleX(1);
        introTextView.setScaleY(1);
        introTextView.animate()
                .alpha(0)
                .scaleX(3)
                .scaleY(3)
                .setDuration(1000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override


                    public void onAnimationEnd(Animator animation) {
                        if (counter > 0) {
                            animateCounter(introTextView, animationsEnd, counter - 1);
                        } else {

                            animationsEnd.run();
                        }
                    }
                })
                .start();
    }

    @Override
    public void onClick(View v) {
            if (firstImageView.getTag().equals(secondImageView.getTag())) {
                if (v.getId() == firstPlayerButton.getId()) {
                    Toast.makeText(this, "PLAYER ONE WINS", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "PLAYER TWO WINS", Toast.LENGTH_LONG).show();
                }
                } else {
                    if (v.getId() == firstPlayerButton.getId()) {
                        Toast.makeText(this, "PLAYER TWO WINS", Toast.LENGTH_LONG).show();
                } else {
                        Toast.makeText(this, "PLAYER ONE WINS", Toast.LENGTH_LONG).show();
                    }


            }

        firstImageView.setVisibility(View.GONE);
        secondImageView.setVisibility(View.GONE);
        startButton.setVisibility(View.VISIBLE);
        countDownTimer.cancel();
        isRunning = false;

//        if (firstImageView.getDrawable().equals(secondImageView.getDrawable()));

//       drawable nie implementuje metody equals
    }
}
