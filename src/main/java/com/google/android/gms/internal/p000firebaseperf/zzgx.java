package com.google.android.gms.internal.p000firebaseperf;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgx  reason: invalid package */
final class zzgx implements Comparable<zzgx>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzgs zzui;
    private final K zzum;

    zzgx(zzgs zzgs, Map.Entry<K, V> entry) {
        this(zzgs, (Comparable) entry.getKey(), entry.getValue());
    }

    zzgx(zzgs zzgs, K k, V v) {
        this.zzui = zzgs;
        this.zzum = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzui.zzjc();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzum, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        K k = this.zzum;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzum);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.zzum;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzgx) obj).getKey());
    }
}
