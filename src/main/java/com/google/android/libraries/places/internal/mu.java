package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class mu implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f12991a = this.f12993c.f12984a.size();

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f12992b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ms f12993c;

    mu(ms msVar) {
        this.f12993c = msVar;
    }

    public final boolean hasNext() {
        int i = this.f12991a;
        return (i > 0 && i <= this.f12993c.f12984a.size()) || a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f12992b == null) {
            this.f12992b = this.f12993c.f12987d.entrySet().iterator();
        }
        return this.f12992b;
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        List<mz> list = this.f12993c.f12984a;
        int i = this.f12991a - 1;
        this.f12991a = i;
        return list.get(i);
    }
}
