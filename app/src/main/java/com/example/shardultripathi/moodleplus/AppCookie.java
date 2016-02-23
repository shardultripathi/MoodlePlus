package com.example.shardultripathi.moodleplus;

import android.app.Application;

import java.net.CookieHandler;
import java.net.CookieManager;

/**
 * Created by Dhairya on 23-02-2016.
 */
public class AppCookie extends Application {
    CookieManager cookieManager;

    public void onCreate(){
        cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        super.onCreate();
    }

}
