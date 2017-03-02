package com.example.rent.myapplication.BooksIMustRead;

import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.rent.myapplication.R;

import java.util.List;

/**
 * Created by RENT on 2017-03-02.
 */

public class BookReaderAdapter extends PagerAdapter {

    private SharedPreferences sharedPreferences;
//    zapisuja na stale informacje do pliku
    private List<Book> books;
    private Book book;


    public BookReaderAdapter(List<Book> books, SharedPreferences preferences) {
        this.books = books;
        this.sharedPreferences = preferences;

    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());

        View pageLayout = inflater.inflate(R.layout.book_page, container, false);

        ImageView image = (ImageView) pageLayout.findViewById(R.id.image);
        image.setImageResource(books.get(position).getImageResourceId());

        CheckBox checkBox = (CheckBox) pageLayout.findViewById(R.id.isRead);
        checkBox.setOnCheckedChangeListener(null);
                checkBox.setChecked(books.get(position).isRead());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                book = books.get(position);
                book.setRead(isChecked);
                sharedPreferences
                        .edit()
                        .putBoolean(String.valueOf(book.getId()), book.isRead())
                        .apply();
            }
        });

        container.addView(pageLayout);
        return pageLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return books.get(position).getTitle();
    }
}


