package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

final class li<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f12931a;

    public li(Iterator<Map.Entry<K, Object>> it) {
        this.f12931a = it;
    }

    public final boolean hasNext() {
        return this.f12931a.hasNext();
    }

    public final void remove() {
        this.f12931a.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f12931a.next();
        return next.getValue() instanceof lg ? new lh(next) : next;
    }
}
