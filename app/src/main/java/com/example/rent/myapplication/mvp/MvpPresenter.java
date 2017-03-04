package com.example.rent.myapplication.mvp;

import nucleus.presenter.Presenter;

/**
 * Created by RENT on 2017-03-04.
 */

public class MvpPresenter extends Presenter<MvpActivity> {

    private LongRunningTask longRunningTask = new LongRunningTask();

    public void exucuteLongRunningTask() {
        new Thread() {
            @Override
            public void run() {
                final String result = longRunningTask.execute();
                getView().setTextOnUiThread(result);
            }
        }.start();
    }
}