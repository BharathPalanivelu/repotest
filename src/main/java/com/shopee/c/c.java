package com.shopee.c;

import android.util.Log;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27113a;

    public static void a(String str) {
        if (f27113a) {
            Log.d("LivePlayerSdk", str);
        }
    }

    public static void b(String str) {
        if (f27113a) {
            Log.e("LivePlayerSdk", str);
        }
    }
}
