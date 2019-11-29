package com.google.android.gms.internal.measurement;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzij {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdp.zzadh),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzajj;

    private zzij(Object obj) {
        this.zzajj = obj;
    }
}
