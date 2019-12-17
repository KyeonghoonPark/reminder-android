package com.smtm.reminders.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import com.smtm.reminders.app.MyApplication;


/**
 * Created by PK on 2019-05-22.
 * <p>
 *
 * @author : PK
 */

public class Dlog {
    static final String TAG = "com.hf.eyeduiro";

    /**
     * Log Level Error
     **/
    @SuppressLint("LongLogTag")
    public static final void e(String message) {
        if (MyApplication.DEBUG)
            Log.e(TAG, buildLogMsg(message));
    }

    /**
     * Log Level Warning
     **/
    @SuppressLint("LongLogTag")
    public static final void w(String message) {
        if (MyApplication.DEBUG)
            Log.w(TAG, buildLogMsg(message));
    }

    /**
     * Log Level Information
     **/
    @SuppressLint("LongLogTag")
    public static final void i(String message) {
        if (MyApplication.DEBUG)
            Log.i(TAG, buildLogMsg(message));
    }

    /**
     * Log Level Debug
     **/
    @SuppressLint("LongLogTag")
    public static final void d(String message) {
        if (MyApplication.DEBUG)
            Log.d(TAG, buildLogMsg(message));
    }

    /**
     * Log Level Verbose
     **/
    @SuppressLint("LongLogTag")
    public static final void v(String message) {
        if (MyApplication.DEBUG)
            Log.v(TAG, buildLogMsg(message));
    }


    public static String buildLogMsg(String message) {

        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(ste.getFileName().replace(".java", ""));
        sb.append("::");
        sb.append(ste.getMethodName());
        sb.append("]  ");
        sb.append(message);
        sb.append(" (").append(Thread.currentThread().getStackTrace()[4].getFileName()).append(":");
        sb.append(Thread.currentThread().getStackTrace()[4].getLineNumber()).append(")");
        return sb.toString();
    }
}
