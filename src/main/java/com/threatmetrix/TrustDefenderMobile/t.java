package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class t {

    /* renamed from: a  reason: collision with root package name */
    private static volatile WebView f32611a;

    /* renamed from: b  reason: collision with root package name */
    private static final Lock f32612b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    private static Context f32613c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String f32614d = t.class.getName();

    private t() {
    }

    public static WebView a(Context context) {
        Context context2 = f32613c;
        if (context2 == null || context2 == context) {
            if (f32611a == null) {
                try {
                    f32612b.lock();
                    if (f32611a == null) {
                        f32611a = new WebView(context);
                        f32613c = context;
                    }
                } finally {
                    f32612b.unlock();
                }
            } else {
                Log.d(f32614d, "Reusing webview");
            }
            return f32611a;
        }
        Log.e(f32614d, "Mismatched context: Only application context should be used, and it should always be consistent between calls");
        return null;
    }

    public static boolean a() {
        try {
            f32612b.lock();
            return f32611a != null;
        } finally {
            f32612b.unlock();
        }
    }
}
