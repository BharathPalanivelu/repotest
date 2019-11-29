package com.shopee.feeds.feedlibrary.a.b;

import android.annotation.SuppressLint;
import android.content.Context;

public final class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Context f27325a;

    public static void a(Context context) {
        f27325a = context.getApplicationContext();
    }

    public static Context a() {
        Context context = f27325a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }
}
