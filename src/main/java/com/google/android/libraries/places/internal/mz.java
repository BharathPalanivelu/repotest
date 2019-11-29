package com.google.android.libraries.places.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Map;

final class mz implements Comparable<mz>, Map.Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f12997a;

    /* renamed from: b  reason: collision with root package name */
    private V f12998b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ms f12999c;

    mz(ms msVar, Map.Entry<K, V> entry) {
        this(msVar, (Comparable) entry.getKey(), entry.getValue());
    }

    mz(ms msVar, K k, V v) {
        this.f12999c = msVar;
        this.f12997a = k;
        this.f12998b = v;
    }

    public final V getValue() {
        return this.f12998b;
    }

    public final V setValue(V v) {
        this.f12999c.e();
        V v2 = this.f12998b;
        this.f12998b = v;
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
        return a(this.f12997a, entry.getKey()) && a(this.f12998b, entry.getValue());
    }

    public final int hashCode() {
        K k = this.f12997a;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f12998b;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12997a);
        String valueOf2 = String.valueOf(this.f12998b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.f12997a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((mz) obj).getKey());
    }
}
