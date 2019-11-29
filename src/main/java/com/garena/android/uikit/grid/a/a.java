package com.garena.android.uikit.grid.a;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final int f7735a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7736b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7737c;

    public int a() {
        int i = this.f7737c;
        if (i == 0) {
            return d();
        }
        if (i == 1) {
            return c();
        }
        if (i != 2) {
            return 0;
        }
        return b();
    }

    private int b() {
        int i = this.f7735a;
        int i2 = this.f7736b;
        int i3 = i / i2;
        return i % i2 > i2 / 2 ? i3 + 1 : i3;
    }

    private int c() {
        return this.f7735a / this.f7736b;
    }

    private int d() {
        int i = this.f7735a;
        int i2 = this.f7736b;
        int i3 = i / i2;
        return i / i3 > i2 ? i3 + 1 : i3;
    }
}
