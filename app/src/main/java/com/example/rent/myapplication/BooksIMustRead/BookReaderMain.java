package com.example.rent.myapplication.BooksIMustRead;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.rent.myapplication.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by RENT on 2017-03-02.
 */

public class BookReaderMain extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_reader);
        setContentView(R.layout.book_page);

        ViewPager viewPager = (ViewPager) findViewById(R.id.book_reader_view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout = setupWithViewPager(viewPager);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Book effJava = new Book(1, R.drawable.effjava, "Effective Java");
        effJava.setRead(sharedPreferences.getBoolean(String.valueOf(effJava.getId()), false));
        Book cleanCode = new Book(2, R.drawable.clncode, "Clean Code");
        effJava.setRead(sharedPreferences.getBoolean(String.valueOf(effJava.getId()), false));
        Book headFirst = new Book(3, R.drawable.headfirst, "Head First");
        effJava.setRead(sharedPreferences.getBoolean(String.valueOf(effJava.getId()), false));

        List<Book> list = Arrays.asList(effJava, cleanCode, headFirst);
        BookReaderAdapter adapter = new BookReaderAdapter(list, sharedPrefences);
        viewPager.setAdapter(adapter);
    }




}
