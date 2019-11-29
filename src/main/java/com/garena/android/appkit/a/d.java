package com.garena.android.appkit.a;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private int f7612a;

    /* renamed from: b  reason: collision with root package name */
    private int f7613b;

    public abstract String a();

    protected d(int i, int i2) {
        this.f7612a = i;
        this.f7613b = i2;
    }

    public boolean a(int i, int i2) {
        if (i >= this.f7612a) {
            int i3 = this.f7613b;
            return i < i3 && i2 >= i3;
        }
    }
}
