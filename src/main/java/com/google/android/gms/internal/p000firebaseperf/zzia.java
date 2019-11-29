package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzia  reason: invalid package */
public enum zzia {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdl.zzmt),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzry;

    private zzia(Object obj) {
        this.zzry = obj;
    }
}
