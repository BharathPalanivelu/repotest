package com.google.android.gms.internal.p000firebaseperf;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbt  reason: invalid package */
public enum zzbt implements zzeu {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    
    private static final zzet<zzbt> zzja = null;
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzew zzdk() {
        return zzbv.zzjf;
    }

    public final String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    private zzbt(int i) {
        this.value = i;
    }

    static {
        zzja = new zzbs();
    }
}
