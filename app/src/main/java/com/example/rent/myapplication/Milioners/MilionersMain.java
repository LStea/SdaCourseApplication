package com.example.rent.myapplication.Milioners;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rent.myapplication.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by RENT on 2017-02-25.
 */

public class MilionersMain extends AppCompatActivity implements View.OnClickListener {

    private static final String INDEX_KEY = "index_key";
    private int currentQuestionIndex;
    private boolean wasViewClicked;


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
            QuizContainer quizContainer = new Gson().fromJson(json, QuizContainer.class);
            TextView textView = (TextView) findViewById(R.id.question);
            QuestionQuiz questionQuiz = quizContainer.getQuestions().get(currentQuestionIndex);
            textView.setText(questionQuiz.getQuestion());

            Button answerOne = (Button) findViewById(R.id.answer_one);
            Button answerTwo = (Button) findViewById(R.id.answer_two);
            Button answerThree = (Button) findViewById(R.id.answer_three);
            Button answerFour = (Button) findViewById(R.id.answer_four);

            SingleAnswer first = questionQuiz.getAnswers().get(0);
            answerOne.setText(first.getText());
            answerOne.setTag(first.isCorrect());

            SingleAnswer second = questionQuiz.getAnswers().get(1);
            answerTwo.setText(second.getText());
            answerTwo.setTag(second.isCorrect());

            SingleAnswer third = questionQuiz.getAnswers().get(2);
            answerThree.setText(third.getText());
            answerThree.setTag(third.isCorrect());

            SingleAnswer fourth = questionQuiz.getAnswers().get(3);
            answerFour.setText(fourth.getText());
            answerThree.setTag(fourth.isCorrect());

            answerOne.setOnClickListener(this);
            answerTwo.setOnClickListener(this);
            answerThree.setOnClickListener(this);
            answerFour.setOnClickListener(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onClick(View v) {
        if (!wasViewClicked) {
            if ((Boolean) v.getTag()) {
                Toast.makeText(v.getContext(), "Odp dobra", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(v.getContext(), "Odp zła", Toast.LENGTH_LONG).show();
            }
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MilionersMain.this, MilionersMain.class);
                    intent.putExtra(INDEX_KEY, ++currentQuestionIndex);
                    startActivity(intent);
                }
            }, 3000);
            wasViewClicked = true; }
    }

            private String loadQuizJson() throws IOException {
                StringBuilder buf = new StringBuilder();
            InputStream json = null;
            try {
                json = getAssets().open("quiz_data.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String string;
                while ((string = in.readLine()) != null) {
                    buf.append(string);
                }
                in.close();
                return buf.toString();

            }
}
