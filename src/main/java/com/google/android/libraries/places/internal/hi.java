package com.google.android.libraries.places.internal;

import java.util.NoSuchElementException;

public final class hi extends hu<T> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12651a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Object f12652b;

    public hi(Object obj) {
        this.f12652b = obj;
    }

    public final boolean hasNext() {
        return !this.f12651a;
    }

    public final T next() {
        if (!this.f12651a) {
            this.f12651a = true;
            return this.f12652b;
        }
        throw new NoSuchElementException();
    }
}
