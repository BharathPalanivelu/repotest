package com.google.android.libraries.places.internal;

import java.util.ListIterator;

final class ni implements ListIterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private ListIterator<String> f13021a = this.f13023c.f13020a.listIterator(this.f13022b);

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f13022b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ nh f13023c;

    ni(nh nhVar, int i) {
        this.f13023c = nhVar;
        this.f13022b = i;
    }

    public final boolean hasNext() {
        return this.f13021a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f13021a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f13021a.nextIndex();
    }

    public final int previousIndex() {
        return this.f13021a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.f13021a.previous();
    }

    public final /* synthetic */ Object next() {
        return this.f13021a.next();
    }
}
