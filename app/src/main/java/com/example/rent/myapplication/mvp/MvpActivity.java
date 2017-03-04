package com.example.rent.myapplication.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rent.myapplication.R;

import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;

/**
 * Created by RENT on 2017-03-04.
 */

@RequiresPresenter(MvpPresenter.class)
public class MvpActivity extends NucleusActivity<MvpPresenter> {
    private static final String RESULT_KEY = "result_key";
    private TextView resultTextView;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        resultTextView = (TextView) findViewById(R.id.result_text_view);
        Button startTaskButton = (Button) findViewById(R.id.task_button);
        startTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().exucuteLongRunningTask();
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RESULT_KEY, resultTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultTextView.setText(savedInstanceState.getString(RESULT_KEY));
    }

    public void setTextOnUiThread(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultTextView.setText(text);
            }
        });
    }
}