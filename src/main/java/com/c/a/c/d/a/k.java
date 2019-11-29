package com.c.a.c.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.c.a.c.b;
import java.io.File;

final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final File f6022a = new File("/proc/self/fd");

    /* renamed from: d  reason: collision with root package name */
    private static volatile k f6023d;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f6024b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f6025c = true;

    static k a() {
        if (f6023d == null) {
            synchronized (k.class) {
                if (f6023d == null) {
                    f6023d = new k();
                }
            }
        }
        return f6023d;
    }

    private k() {
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean a(int i, int i2, BitmapFactory.Options options, b bVar, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }

    private synchronized boolean b() {
        int i = this.f6024b + 1;
        this.f6024b = i;
        if (i >= 50) {
            boolean z = false;
            this.f6024b = 0;
            int length = f6022a.list().length;
            if (length < 700) {
                z = true;
            }
            this.f6025c = z;
            if (!this.f6025c && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + 700);
            }
        }
        return this.f6025c;
    }
}
