package com.google.android.libraries.places.internal;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Iterator;

final class ht<E> extends hg<E> {

    /* renamed from: a  reason: collision with root package name */
    private final transient E f6734a;
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient int f6735b;

    ht(E e2) {
        this.f6734a = go.a(e2);
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return false;
    }

    public final int size() {
        return 1;
    }

    ht(E e2, int i) {
        this.f6734a = e2;
        this.f6735b = i;
    }

    public final boolean contains(Object obj) {
        return this.f6734a.equals(obj);
    }

    public final hu<E> a() {
        return go.d(this.f6734a);
    }

    /* access modifiers changed from: package-private */
    public final ha<E> h() {
        return ha.a(this.f6734a);
    }

    /* access modifiers changed from: package-private */
    public final int a(Object[] objArr, int i) {
        objArr[i] = this.f6734a;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.f6735b;
        if (i != 0) {
            return i;
        }
        int hashCode = this.f6734a.hashCode();
        this.f6735b = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return this.f6735b != 0;
    }

    public final String toString() {
        String obj = this.f6734a.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
