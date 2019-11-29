package com.google.android.libraries.places.internal;

import java.util.ListIterator;

public abstract class hv<E> extends hu<E> implements ListIterator<E> {
    protected hv() {
    }

    @Deprecated
    public final void add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e2) {
        throw new UnsupportedOperationException();
    }
}
