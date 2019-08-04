package com.example.svbloglib;

import android.util.Log;

public class LogDebug {
    private static final String TAG = "SVB_LOG";

    public static void d(String message){
        Log.d(TAG, message);
    }
}
