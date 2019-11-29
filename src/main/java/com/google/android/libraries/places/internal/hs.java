package com.google.android.libraries.places.internal;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class hs<E> extends hg<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final hs<Object> f6728a = new hs(new Object[0], 0, (Object[]) null, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    private final transient Object[] f6729b;

    /* renamed from: c  reason: collision with root package name */
    private final transient Object[] f6730c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f6731d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f6732e;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f6733f;

    hs(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f6729b = objArr;
        this.f6730c = objArr2;
        this.f6731d = i2;
        this.f6732e = i;
        this.f6733f = i3;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return true;
    }

    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.f6730c;
        if (obj == null || objArr == null) {
            return false;
        }
        int c2 = go.c(obj);
        while (true) {
            int i = c2 & this.f6731d;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            c2 = i + 1;
        }
    }

    public final int size() {
        return this.f6733f;
    }

    public final hu<E> a() {
        return (hu) e().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Object[] b() {
        return this.f6729b;
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.f6733f;
    }

    /* access modifiers changed from: package-private */
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.f6729b, 0, objArr, i, this.f6733f);
        return i + this.f6733f;
    }

    /* access modifiers changed from: package-private */
    public final ha<E> h() {
        return ha.b(this.f6729b, this.f6733f);
    }

    public final int hashCode() {
        return this.f6732e;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
