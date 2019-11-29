package com.google.android.gms.internal.p000firebaseperf;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdb  reason: invalid package */
public enum zzdb implements zzeu {
    VISIBILITY_STATE_UNKNOWN(0),
    VISIBLE(1),
    HIDDEN(2),
    PRERENDER(3),
    UNLOADED(4);
    
    private static final zzet<zzdb> zzja = null;
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzew zzdk() {
        return zzdc.zzjf;
    }

    public final String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    private zzdb(int i) {
        this.value = i;
    }

    static {
        zzja = new zzdd();
    }
}
