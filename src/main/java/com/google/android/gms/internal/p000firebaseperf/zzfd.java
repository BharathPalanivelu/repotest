package com.google.android.gms.internal.p000firebaseperf;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfd  reason: invalid package */
final class zzfd<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzfb> zzsa;

    private zzfd(Map.Entry<K, zzfb> entry) {
        this.zzsa = entry;
    }

    public final K getKey() {
        return this.zzsa.getKey();
    }

    public final Object getValue() {
        if (this.zzsa.getValue() == null) {
            return null;
        }
        return zzfb.zzhu();
    }

    public final zzfb zzhw() {
        return this.zzsa.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzga) {
            return this.zzsa.getValue().zzh((zzga) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
