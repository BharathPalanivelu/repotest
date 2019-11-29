package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfc  reason: invalid package */
public enum zzfc {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdl.class, zzdl.class, zzdl.zzmt),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzrw;
    private final Class<?> zzrx;
    private final Object zzry;

    private zzfc(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzrw = cls;
        this.zzrx = cls2;
        this.zzry = obj;
    }

    public final Class<?> zzhv() {
        return this.zzrx;
    }
}
