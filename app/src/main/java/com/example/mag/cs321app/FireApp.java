package com.example.mag.cs321app;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by eunicewang on 4/19/17.
 */

public class FireApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
