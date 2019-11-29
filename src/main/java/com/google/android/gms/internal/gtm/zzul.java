package com.google.android.gms.internal.gtm;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzul {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzps.zzavx),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzbbx;

    private zzul(Object obj) {
        this.zzbbx = obj;
    }
}
