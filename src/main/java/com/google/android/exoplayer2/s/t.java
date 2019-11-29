package com.google.android.exoplayer2.s;

import android.annotation.TargetApi;
import android.os.Trace;

public final class t {
    public static void a(String str) {
        if (v.f11449a >= 18) {
            b(str);
        }
    }

    public static void a() {
        if (v.f11449a >= 18) {
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
