package com.google.android.libraries.places.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class nh extends AbstractList<String> implements ll, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    public final ll f13020a;

    public nh(ll llVar) {
        this.f13020a = llVar;
    }

    public final ll e() {
        return this;
    }

    public final Object a(int i) {
        return this.f13020a.a(i);
    }

    public final int size() {
        return this.f13020a.size();
    }

    public final void a(kc kcVar) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new ni(this, i);
    }

    public final Iterator<String> iterator() {
        return new nj(this);
    }

    public final List<?> d() {
        return this.f13020a.d();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.f13020a.get(i);
    }
}
