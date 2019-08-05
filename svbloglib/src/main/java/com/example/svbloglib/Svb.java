package com.example.svbloglib;

import android.util.Log;

public class Svb {
    private static String TAG;

    public static void logd(String message){
        TAG = "SVB_DEBUG_LOG";
        Log.d(TAG, message);
    }

    public static void loge(String message){
        TAG = "SVB_ERROR_LOG";
        Log.e(TAG, message);
    }

    public static void logv(String message){
        TAG = "SVB_VERBOSE_LOG";
        Log.v(TAG, message);
    }
}
