package com.google.android.gms.internal.vision;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Map;

final class zzex implements Comparable<zzex>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzeq zzom;
    private final K zzop;

    zzex(zzeq zzeq, K k, V v) {
        this.zzom = zzeq;
        this.zzop = k;
        this.value = v;
    }

    zzex(zzeq zzeq, Map.Entry<K, V> entry) {
        this(zzeq, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzex) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzop, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzop;
    }

    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        K k = this.zzop;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzom.zzdo();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzop);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(valueOf2);
        return sb.toString();
    }
}
