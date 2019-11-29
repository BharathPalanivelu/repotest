package com.airpay.paysdk.common.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3981a;

    public static NetworkInfo a() {
        Context context = f3981a;
        if (context == null) {
            return null;
        }
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean b() {
        NetworkInfo a2 = a();
        return a2 != null && a2.isConnected();
    }

    public static void a(Context context) {
        f3981a = context.getApplicationContext();
    }

    public static void c() {
        f3981a = null;
    }
}
