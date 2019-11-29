package com.shopee.app.application;

public abstract class am {

    /* renamed from: a  reason: collision with root package name */
    private final int f15862a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15863b;

    public abstract void a();

    public am(int i, int i2) {
        this.f15862a = i;
        this.f15863b = i2;
    }

    public boolean a(int i, int i2) {
        if (i >= this.f15862a) {
            int i3 = this.f15863b;
            return i < i3 && i2 >= i3;
        }
    }
}
