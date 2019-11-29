package com.scottyab.rootbeer.a;

import android.util.Log;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f15730a = 5;

    public static void a(Object obj) {
        if (b()) {
            Log.e("RootBeer", c() + String.valueOf(obj));
            Log.e("QLog", c() + String.valueOf(obj));
        }
    }

    public static void b(Object obj) {
        if (a()) {
            Log.v("RootBeer", c() + String.valueOf(obj));
        }
    }

    public static boolean a() {
        return f15730a > 4;
    }

    public static boolean b() {
        return f15730a > 0;
    }

    private static String c() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        int lineNumber = stackTrace[2].getLineNumber();
        String substring = className.substring(className.lastIndexOf(46) + 1);
        return substring + ": " + methodName + "() [" + lineNumber + "] - ";
    }
}
