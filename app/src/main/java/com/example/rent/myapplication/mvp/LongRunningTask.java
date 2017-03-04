package com.example.rent.myapplication.mvp;

/**
 * Created by RENT on 2017-03-04.
 */

public class LongRunningTask {

    public static String execute() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Udalo sie";
    }
    }
