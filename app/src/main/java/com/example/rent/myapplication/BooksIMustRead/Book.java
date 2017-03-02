package com.example.rent.myapplication.BooksIMustRead;

import android.support.annotation.DrawableRes;

/**
 * Created by RENT on 2017-03-02.
 */




public class Book {

    private int id;
    private boolean isRead;
    @DrawableRes
    private int imageResourceId;
    private String title;
    private Book book;

    public Book (int id, int imageResourceId, String title) {
        this.imageResourceId = imageResourceId;
        this.id = id;
        this.title = title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
