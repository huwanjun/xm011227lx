package com.bawei.xm011227lx;

import android.app.Application;

/**
 * author: 斛万珺
 * data: 2019/12/27 16:16:29
 * function:
 */
public class App extends Application {

    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;

    }
}
