package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzkr {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzfx.zzov),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzuq;

    private zzkr(Object obj) {
        this.zzuq = obj;
    }
}
