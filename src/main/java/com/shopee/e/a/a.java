package com.shopee.e.a;

import android.content.Context;
import android.util.Log;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static b f27140a;

    public static void a(Context context) {
        if (f27140a == null) {
            try {
                f27140a = new c(context);
            } catch (Exception e2) {
                Log.e("Log", "init log failed", e2);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        b bVar = f27140a;
        if (bVar == null) {
            Log.e("Log", "Please call init first.");
        } else {
            bVar.a(str, objArr);
        }
    }

    public static void a(Object obj) {
        b bVar = f27140a;
        if (bVar == null) {
            Log.e("Log", "Please call init first.");
        } else {
            bVar.a(obj);
        }
    }

    public static void b(String str, Object... objArr) {
        b bVar = f27140a;
        if (bVar == null) {
            Log.e("Log", "Please call init first.");
        } else {
            bVar.b(str, objArr);
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        b bVar = f27140a;
        if (bVar == null) {
            Log.e("Log", "Please call init first.");
        } else {
            bVar.a(th, str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        b bVar = f27140a;
        if (bVar == null) {
            Log.e("Log", "Please call init first.");
        } else {
            bVar.c(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        b bVar = f27140a;
        if (bVar == null) {
            Log.e("Log", "Please call init first.");
        } else {
            bVar.d(str, objArr);
        }
    }
}
