package com.smtm.reminders.utils;

/**
 * Created by Ezequiel Adrian on 24/02/2017.
 */

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.PointF;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Utils {

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }


    public static int getScreenHeight(Context c) {
        WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public static int getScreenWidth(Context c) {
        WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    public static float getScreenRatio(Context c) {
        DisplayMetrics metrics = c.getResources().getDisplayMetrics();
        return ((float) metrics.heightPixels / (float) metrics.widthPixels);
    }

    public static int getScreenRotation(Context c) {
        WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getRotation();
    }

    public static int distancePointsF(PointF p1, PointF p2) {
        return (int) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static PointF middlePoint(PointF p1, PointF p2) {
        if (p1 == null || p2 == null)
            return null;
        return new PointF((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }


    public static String formatDuration(Context context, long diff) {
        int diffMilliseconds = (int) (diff % 1000);
        int diffSeconds = (int) (diff / 1000 % 60);
        int diffMinutes = (int) (diff / (60 * 1000) % 60);
        int diffHours = (int) (diff / (60 * 60 * 1000) % 24);
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));

        String str = "";

        if (diffDays > 0)
            str = diffDays + "일" + " " + formatTime(diffHours) + ":" + formatTime(diffMinutes) + ":" + formatTime(diffSeconds);
        else if (diffHours > 0)
            str = formatTime(diffHours) + ":" + formatTime(diffMinutes) + ":" + formatTime(diffSeconds);
        else
            str = formatTime(diffMinutes) + ":" + formatTime(diffSeconds);

        return str;
    }

    public static String formatMinutes(Context context, long diff) {
        int diffMinutes = (int) (diff / (60 * 1000) % 60);
        String temp = formatTime(diffMinutes);
        if (temp.equals("00")) {
            temp = "60";
        }

//        String str = temp + context.getString(R.string.minutes);
        return temp;
    }

    public static String formatTime(int tt) {
        return String.format("%02d", tt);
    }


    public static float CM_TO_MM(final float cm) {
        return cm * 10;
    }

    public static float CM_TO_MM(final int cm) {
        return cm * 10.0f;
    }

    public static float MM_TO_CM(final float mm) {
        return mm / 10;
    }

    public static float MM_TO_CM(final int mm) {
        return mm / 10.0f;
    }



    public static String StringReplace(String str) {
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        str = str.replaceAll(match, "");
        return str;
    }

    /**
     * convert string date to timestamp
     *
     * @param str_date
     * @return
     */
    public static Timestamp convertStringToTimestamp(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy.MM.dd");
            // you can change format of date
            Date date = formatter.parse(str_date);
            Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }

    /**
     * convert string date to timestamp
     *
     * @param str_date
     * @return
     */
    public static Date convertStringToDate(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy.MM.dd");
            // you can change format of date
            Date date = formatter.parse(str_date);

            return date;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }








    /**
     * setting keyboard hide
     *
     * @param context
     */
    public static void hideKeyBoard(Activity context) {
        if (context == null) return;
        View view = context.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Setting keyboard show
     *
     * @param context
     * @param view
     */
    public static void showKeyBoard(Context context, View view) {
        if (context == null) return;
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }


    @SuppressLint("NewApi")
    public static int getSwWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        } else
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int dpi = 0;
        if (metrics.widthPixels < metrics.heightPixels) {
            dpi = (int) (metrics.widthPixels / metrics.density);
        } else {
            dpi = (int) (metrics.heightPixels / metrics.density);
        }

        return dpi;
    }

}
