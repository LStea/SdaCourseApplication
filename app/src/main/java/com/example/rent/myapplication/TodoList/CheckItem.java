package com.example.rent.myapplication.TodoList;

import java.util.List;

/**
 * Created by RENT on 2017-02-23.
 */

public class CheckItem {

    private String text;
    private boolean isChecked;

    public CheckItem(String items) {

    }




    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
