package com.google.android.gms.internal.icing;

import java.util.Map;

final class zzed<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzeb> zzlk;

    private zzed(Map.Entry<K, zzeb> entry) {
        this.zzlk = entry;
    }

    public final K getKey() {
        return this.zzlk.getKey();
    }

    public final Object getValue() {
        if (this.zzlk.getValue() == null) {
            return null;
        }
        return zzeb.zzcb();
    }

    public final zzeb zzcc() {
        return this.zzlk.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzex) {
            return this.zzlk.getValue().zzh((zzex) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
