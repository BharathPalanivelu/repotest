package com.google.android.libraries.places.internal;

import java.util.NoSuchElementException;

class gt<E> extends hv<E> {

    /* renamed from: a  reason: collision with root package name */
    public final ha<E> f12635a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12636b;

    /* renamed from: c  reason: collision with root package name */
    private int f12637c;

    /* access modifiers changed from: protected */
    public E a(int i) {
        return this.f12635a.get(i);
    }

    protected gt(int i, int i2) {
        go.b(i2, i);
        this.f12636b = i;
        this.f12637c = i2;
    }

    public final boolean hasNext() {
        return this.f12637c < this.f12636b;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.f12637c;
            this.f12637c = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f12637c;
    }

    public final boolean hasPrevious() {
        return this.f12637c > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.f12637c - 1;
            this.f12637c = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f12637c - 1;
    }

    gt(ha<E> haVar, int i) {
        this(haVar.size(), i);
        this.f12635a = haVar;
    }
}
