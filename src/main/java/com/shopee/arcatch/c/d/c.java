package com.shopee.arcatch.c.d;

import android.content.Context;
import android.graphics.Point;
import com.shopee.arcatch.b.c.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private Point f26772a;

    /* renamed from: b  reason: collision with root package name */
    private int f26773b;

    /* renamed from: c  reason: collision with root package name */
    private int f26774c;

    /* renamed from: d  reason: collision with root package name */
    private int f26775d;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final c f26776a = new c();
    }

    private c() {
        this.f26772a = new Point(0, 0);
        this.f26773b = 0;
        this.f26774c = 0;
        this.f26775d = 0;
    }

    public static c a() {
        return a.f26776a;
    }

    public void a(Context context, int i, int i2) {
        int a2 = b.a(context, 602.0f);
        int a3 = b.a(context, 248.0f);
        int a4 = b.a(context, 50.0f);
        this.f26774c = i;
        this.f26775d = i2;
        float f2 = (float) i2;
        float f3 = f2 / ((float) a2);
        Point point = this.f26772a;
        point.x = i / 2;
        int i3 = (a3 - a4) / 2;
        point.y = (int) (f2 - (((float) (a4 + i3)) * f3));
        this.f26773b = (int) (((float) i3) * f3);
    }

    public boolean a(Point point) {
        if (this.f26774c == 0 || this.f26775d == 0) {
            return false;
        }
        return b(point);
    }

    private boolean b(Point point) {
        int i = this.f26773b;
        return Math.pow((double) (point.x - this.f26772a.x), 2.0d) + Math.pow((double) (point.y - this.f26772a.y), 2.0d) <= ((double) (i * i));
    }
}
