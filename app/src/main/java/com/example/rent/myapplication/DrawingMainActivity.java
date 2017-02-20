package com.example.rent.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class DrawingMainActivity extends AppCompatActivity {
    private Button blueButton;
    private Button redButton;

    private SimpleDrawingView simpleDrawingView;

//    private Button blueButton;
//    private Button redButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawing_activity_main);
        final SimpleDrawingView simpleDrawingView = (SimpleDrawingView) findViewById(R.id.drawing_view);
        Button clearButton = (Button) findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                blueButton = (Button) findViewById(R.id.blue_button);
                redButton = (Button) findViewById(R.id.red_button);

                blueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        simpleDrawingView.setOnClickListener(ContextCompat.getColor(DrawingMainActivity.this, R.color.blue));
                    }
                });
//                simpleDrawingView.clear();
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleDrawingView.setOnClickListener(ContextCompat.getColor(DrawingMainActivity.this, R.color.red));
            }
        });
//        simpleDrawingView.clear();
    }


        @Override
                public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return false;
        }



            public boolean onOptionsItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.clear) {

                    simpleDrawingView.clear();
                }
        return super.onCreateOptionsMenu(menu);
            }

        }


