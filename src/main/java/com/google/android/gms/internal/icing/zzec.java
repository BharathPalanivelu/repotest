package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

final class zzec<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzlj;

    public zzec(Iterator<Map.Entry<K, Object>> it) {
        this.zzlj = it;
    }

    public final boolean hasNext() {
        return this.zzlj.hasNext();
    }

    public final void remove() {
        this.zzlj.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzlj.next();
        return next.getValue() instanceof zzeb ? new zzed(next) : next;
    }
}
