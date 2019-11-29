package com.bca.xco.widget.e;

import android.util.Log;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f5274a = "OneKlik";

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f5275b = true;

    public static void a(String str, String str2) {
        if (f5275b.booleanValue()) {
            Log.i(f5274a + " - " + str, str2 + ".");
        }
    }

    public static void b(String str, String str2) {
        if (f5275b.booleanValue()) {
            Log.d(f5274a + " - " + str, str2 + ".");
        }
    }
}
