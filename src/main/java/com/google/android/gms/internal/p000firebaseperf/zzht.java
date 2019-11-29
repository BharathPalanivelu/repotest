package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzht  reason: invalid package */
public enum zzht {
    DOUBLE(zzia.DOUBLE, 1),
    FLOAT(zzia.FLOAT, 5),
    INT64(zzia.LONG, 0),
    UINT64(zzia.LONG, 0),
    INT32(zzia.INT, 0),
    FIXED64(zzia.LONG, 1),
    FIXED32(zzia.INT, 5),
    BOOL(zzia.BOOLEAN, 0),
    STRING(zzia.STRING, 2),
    GROUP(zzia.MESSAGE, 3),
    MESSAGE(zzia.MESSAGE, 2),
    BYTES(zzia.BYTE_STRING, 2),
    UINT32(zzia.INT, 0),
    ENUM(zzia.ENUM, 0),
    SFIXED32(zzia.INT, 5),
    SFIXED64(zzia.LONG, 1),
    SINT32(zzia.INT, 0),
    SINT64(zzia.LONG, 0);
    
    private final zzia zzwl;
    private final int zzwm;

    private zzht(zzia zzia, int i) {
        this.zzwl = zzia;
        this.zzwm = i;
    }

    public final zzia zzjp() {
        return this.zzwl;
    }

    public final int zzjq() {
        return this.zzwm;
    }
}
