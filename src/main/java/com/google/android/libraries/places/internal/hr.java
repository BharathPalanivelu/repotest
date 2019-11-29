package com.google.android.libraries.places.internal;

final class hr extends ha<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final transient Object[] f12661a;

    /* renamed from: b  reason: collision with root package name */
    private final transient int f12662b;

    /* renamed from: c  reason: collision with root package name */
    private final transient int f12663c;

    hr(Object[] objArr, int i, int i2) {
        this.f12661a = objArr;
        this.f12662b = i;
        this.f12663c = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return true;
    }

    public final Object get(int i) {
        go.a(i, this.f12663c);
        return this.f12661a[(i * 2) + this.f12662b];
    }

    public final int size() {
        return this.f12663c;
    }
}
