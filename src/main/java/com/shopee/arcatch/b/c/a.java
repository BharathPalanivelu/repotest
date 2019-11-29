package com.shopee.arcatch.b.c;

import android.os.Handler;
import android.os.HandlerThread;

public class a extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    private static a f26678a;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f26679b;

    private a() {
        super("ArCatch.bg", 10);
    }

    private static void c() {
        if (f26678a == null) {
            f26678a = new a();
            f26678a.start();
            f26679b = new Handler(f26678a.getLooper());
        }
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            c();
            handler = f26679b;
        }
        return handler;
    }

    public static void b() {
        a aVar = f26678a;
        if (aVar != null) {
            aVar.quit();
            f26678a = null;
        }
    }
}
