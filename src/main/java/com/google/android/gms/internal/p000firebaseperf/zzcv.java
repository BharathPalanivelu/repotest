package com.google.android.gms.internal.p000firebaseperf;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcv  reason: invalid package */
public enum zzcv implements zzeu {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);
    
    private static final zzet<zzcv> zzja = null;
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzcv zzo(int i) {
        if (i == 0) {
            return SESSION_VERBOSITY_NONE;
        }
        if (i != 1) {
            return null;
        }
        return GAUGES_AND_SYSTEM_EVENTS;
    }

    public static zzew zzdk() {
        return zzcx.zzjf;
    }

    public final String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    private zzcv(int i) {
        this.value = i;
    }

    static {
        zzja = new zzcy();
    }
}
