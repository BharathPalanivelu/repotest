package com.google.android.exoplayer2.n;

import android.annotation.TargetApi;
import android.os.Trace;

public final class r {
    public static void a(String str) {
        if (t.f10975a >= 18) {
            b(str);
        }
    }

    public static void a() {
        if (t.f10975a >= 18) {
            b();
        }
    }

    @TargetApi(18)
    private static void b(String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    private static void b() {
        Trace.endSection();
    }
}
