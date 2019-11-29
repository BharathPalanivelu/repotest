package com.google.android.libraries.places.internal;

import java.util.Iterator;

public abstract class hu<E> implements Iterator<E> {
    protected hu() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
