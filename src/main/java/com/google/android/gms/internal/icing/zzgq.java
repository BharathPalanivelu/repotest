package com.google.android.gms.internal.icing;

public enum zzgq {
    DOUBLE(zzgx.DOUBLE, 1),
    FLOAT(zzgx.FLOAT, 5),
    INT64(zzgx.LONG, 0),
    UINT64(zzgx.LONG, 0),
    INT32(zzgx.INT, 0),
    FIXED64(zzgx.LONG, 1),
    FIXED32(zzgx.INT, 5),
    BOOL(zzgx.BOOLEAN, 0),
    STRING(zzgx.STRING, 2),
    GROUP(zzgx.MESSAGE, 3),
    MESSAGE(zzgx.MESSAGE, 2),
    BYTES(zzgx.BYTE_STRING, 2),
    UINT32(zzgx.INT, 0),
    ENUM(zzgx.ENUM, 0),
    SFIXED32(zzgx.INT, 5),
    SFIXED64(zzgx.LONG, 1),
    SINT32(zzgx.INT, 0),
    SINT64(zzgx.LONG, 0);
    
    private final zzgx zzpq;
    private final int zzpr;

    private zzgq(zzgx zzgx, int i) {
        this.zzpq = zzgx;
        this.zzpr = i;
    }

    public final zzgx zzdu() {
        return this.zzpq;
    }

    public final int zzdv() {
        return this.zzpr;
    }
}
