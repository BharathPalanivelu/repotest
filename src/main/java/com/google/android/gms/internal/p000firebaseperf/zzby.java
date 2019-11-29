package com.google.android.gms.internal.p000firebaseperf;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzby  reason: invalid package */
public enum zzby implements zzeu {
    EFFECTIVE_CONNECTION_TYPE_UNKNOWN(0),
    EFFECTIVE_CONNECTION_TYPE_SLOW_2G(1),
    EFFECTIVE_CONNECTION_TYPE_2G(2),
    EFFECTIVE_CONNECTION_TYPE_3G(3),
    EFFECTIVE_CONNECTION_TYPE_4G(4);
    
    private static final zzet<zzby> zzja = null;
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzew zzdk() {
        return zzca.zzjf;
    }

    public final String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    private zzby(int i) {
        this.value = i;
    }

    static {
        zzja = new zzbx();
    }
}
