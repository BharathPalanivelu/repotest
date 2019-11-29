package com.google.android.libraries.places.internal;

final class hm<E> extends ha<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final ha<Object> f12653a = new hm(new Object[0], 0);

    /* renamed from: b  reason: collision with root package name */
    private final transient Object[] f12654b;

    /* renamed from: c  reason: collision with root package name */
    private final transient int f12655c;

    hm(Object[] objArr, int i) {
        this.f12654b = objArr;
        this.f12655c = i;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return false;
    }

    public final int size() {
        return this.f12655c;
    }

    /* access modifiers changed from: package-private */
    public final Object[] b() {
        return this.f12654b;
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.f12655c;
    }

    /* access modifiers changed from: package-private */
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.f12654b, 0, objArr, i, this.f12655c);
        return i + this.f12655c;
    }

    public final E get(int i) {
        go.a(i, this.f12655c);
        return this.f12654b[i];
    }
}
