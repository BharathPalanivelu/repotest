package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map;

final class zzhw<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzuw;

    public zzhw(Iterator<Map.Entry<K, Object>> it) {
        this.zzuw = it;
    }

    public final boolean hasNext() {
        return this.zzuw.hasNext();
    }

    public final void remove() {
        this.zzuw.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzuw.next();
        return next.getValue() instanceof zzhr ? new zzht(next) : next;
    }
}
