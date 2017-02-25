package com.example.rent.myapplication.Milioners;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rent.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by RENT on 2017-02-25.
 */

public class MilionersMain extends AppCompatActivity implements View.OnClickListener {

    private TextView question;
    private ProgressBar progressBar;
    private View answerOne;
    private View answerTwo;
    private View answerThree;
    private View answerFour;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milioners_main);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        ValueAnimator objectAnimator = ObjectAnimator.ofInt(0, 100);
        objectAnimator.setDuration(10000);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressBar.setProgress((Integer)
                        animation.getAnimatedValue());
            }
        });
        objectAnimator.start();

        String json = null;
        try {
            json = loadQuizJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    private String loadQuizJson() throws IOException {
        StringBuilder buf = new StringBuilder();
        InputStream json = getAssets().open("quiz_data-json.json");
        BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
        String string;
        while ((string = in.readLine()) != null) {
            buf.append(string);
        }
        in.close();
        return buf.toString();

    }

    @Override
    public void onClick(View v) {

        Button answerOne = (Button) findViewById(R.id.answer_one);
    }
}
