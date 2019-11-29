package com.garena.reactpush;

import com.garena.reactpush.c.d;
import com.google.a.f;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static f f6698a = new f();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f6699b = true;

    /* renamed from: c  reason: collision with root package name */
    public static float[] f6700c = {1.0f, 1.5f, 2.0f, 3.0f};

    /* renamed from: d  reason: collision with root package name */
    public static d f6701d = new d() {
        public void a(Exception exc) {
        }

        public void a(String str) {
        }

        public void b(String str) {
        }
    };

    private static float b(float f2) {
        for (float f3 : f6700c) {
            if (f3 >= f2) {
                return f3;
            }
        }
        float[] fArr = f6700c;
        return fArr[fArr.length - 1];
    }

    public static String a(float f2) {
        float b2 = b(f2);
        if (b2 == 1.0f) {
            return "mdpi";
        }
        if (b2 == 1.5f) {
            return "hdpi";
        }
        if (b2 == 2.0f) {
            return "xhdpi";
        }
        if (b2 == 3.0f) {
        }
        return "xxhdpi";
    }
}
