package com.google.android.libraries.places.internal;

import java.util.Iterator;

final class nj implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f13024a = this.f13025b.f13020a.iterator();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ nh f13025b;

    nj(nh nhVar) {
        this.f13025b = nhVar;
    }

    public final boolean hasNext() {
        return this.f13024a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.f13024a.next();
    }
}
