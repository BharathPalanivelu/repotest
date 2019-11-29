package com.shopee.arcatch.c.g;

import com.shopee.arcatch.c.f.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26878a = false;

    public static float a(long j) {
        return 80.0f;
    }

    public static float a() {
        int a2 = b.a();
        if (a2 != 0) {
            return (a2 == 1 || a2 == 2) ? 0.3f : 0.1f;
        }
        return 0.35f;
    }

    public static int b() {
        int a2 = b.a();
        boolean z = true;
        int i = (a2 == 0 || a2 == 1 || a2 != 2) ? 0 : 1;
        if (i != 1) {
            z = false;
        }
        f26878a = z;
        return i;
    }

    public static int c() {
        int a2 = b.a();
        return (a2 == 0 || a2 == 1) ? 0 : 0;
    }

    public static int d() {
        int a2 = b.a();
        return (a2 == 0 || a2 == 1) ? 0 : 0;
    }

    public static float e() {
        int a2 = b.a();
        if (a2 != 0) {
            return (a2 == 1 || a2 != 2) ? 30.0f : 35.0f;
        }
        return 24.0f;
    }
}
