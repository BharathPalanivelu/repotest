package com.shopee.shopeetracker.utils;

import android.util.Log;

public final class Logger {
    public static boolean DEBUG = false;
    private static final String TAG = "Logger";

    private Logger() {
    }

    public static void debug(String str, String str2) {
        if (DEBUG) {
            Log.d(str, "" + str2);
        }
    }

    public static void debug(String str) {
        if (DEBUG) {
            String str2 = TAG;
            Log.d(str2, "" + str);
        }
    }

    public static void debug(Throwable th) {
        if (DEBUG) {
            th.printStackTrace();
        }
    }

    public static void locallyLogException(Throwable th) {
        if (DEBUG) {
            th.printStackTrace();
        }
    }
}
