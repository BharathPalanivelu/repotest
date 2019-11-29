package com.google.android.gms.internal.p000firebaseperf;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcu  reason: invalid package */
public enum zzcu implements zzeu {
    SERVICE_WORKER_STATUS_UNKNOWN(0),
    UNSUPPORTED(1),
    CONTROLLED(2),
    UNCONTROLLED(3);
    
    private static final zzet<zzcu> zzja = null;
    private final int value;

    public final int zzdj() {
        return this.value;
    }

    public static zzew zzdk() {
        return zzcw.zzjf;
    }

    public final String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    private zzcu(int i) {
        this.value = i;
    }

    static {
        zzja = new zzct();
    }
}
