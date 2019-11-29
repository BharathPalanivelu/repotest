package com.google.android.libraries.places.internal;

import java.util.Map;

final class lh<K> implements Map.Entry<K, Object> {

    /* renamed from: a  reason: collision with root package name */
    public Map.Entry<K, lg> f12930a;

    lh(Map.Entry<K, lg> entry) {
        this.f12930a = entry;
    }

    public final K getKey() {
        return this.f12930a.getKey();
    }

    public final Object getValue() {
        if (this.f12930a.getValue() == null) {
            return null;
        }
        return lg.a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof ma) {
            lg value = this.f12930a.getValue();
            ma maVar = value.f12933b;
            value.f12932a = null;
            value.f12934c = null;
            value.f12933b = (ma) obj;
            return maVar;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
