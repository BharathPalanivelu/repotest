package com.google.android.libraries.places.internal;

import java.util.List;

final class hc extends ha<E> {

    /* renamed from: a  reason: collision with root package name */
    private final transient int f12642a;

    /* renamed from: b  reason: collision with root package name */
    private final transient int f12643b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ha f12644c;

    hc(ha haVar, int i, int i2) {
        this.f12644c = haVar;
        this.f12642a = i;
        this.f12643b = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return true;
    }

    public final int size() {
        return this.f12643b;
    }

    /* access modifiers changed from: package-private */
    public final Object[] b() {
        return this.f12644c.b();
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return this.f12644c.c() + this.f12642a;
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.f12644c.c() + this.f12642a + this.f12643b;
    }

    public final E get(int i) {
        go.a(i, this.f12643b);
        return this.f12644c.get(i + this.f12642a);
    }

    public final ha<E> a(int i, int i2) {
        go.a(i, i2, this.f12643b);
        ha haVar = this.f12644c;
        int i3 = this.f12642a;
        return (ha) haVar.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
