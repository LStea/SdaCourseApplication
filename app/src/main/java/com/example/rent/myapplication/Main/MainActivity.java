package com.example.rent.myapplication.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.rent.myapplication.BooksIMustRead.BookReaderMain;
import com.example.rent.myapplication.Drawing.DrawingMainActivity;
import com.example.rent.myapplication.Fortune.FortuneActivity;
import com.example.rent.myapplication.Milioners.MilionersMain;

import com.example.rent.myapplication.R;
import com.example.rent.myapplication.SpeedTest.SpeedTestActivity;
import com.example.rent.myapplication.TodoList.TodoListActivity;
import com.example.rent.myapplication.mvp.MvpActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        pokazywanie tytułu aplikacji

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //        nawigacja do góry

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);

        TextView textView = (TextView) findViewById(R.id.drawing_app);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((v.getContext()), DrawingMainActivity.class);
                startActivity(intent);
            }

        });

        TextView todoAplication = (TextView) findViewById(R.id.todo_application);
        todoAplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TodoListActivity.class);
                startActivity(intent);
            }
        });
        TextView milionersMain = (TextView) findViewById(R.id.milioners_application);
        milionersMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MilionersMain.class);
                startActivity(intent);
            }
        });

        TextView speedTest = (TextView) findViewById(R.id.speedTest_application);
        speedTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpeedTestActivity.class);
                startActivity(intent);
            }
        });

        TextView bookReader = (TextView) findViewById(R.id.book_reader_application);
        bookReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookReaderMain.class);
                startActivity(intent);
            }
        });

        TextView fortune = (TextView) findViewById(R.id.fortune_application);
        fortune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FortuneActivity.class);
                startActivity(intent);
            }
        });

        TextView mvp = (TextView) findViewById(R.id.mvp_application);
        mvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MvpActivity.class);
                startActivity(intent);
            }
        });
    }




    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                break;
//                strzałka, jako powrót do strony głównej
            }
        }
        return super.onOptionsItemSelected(item);


    }
}