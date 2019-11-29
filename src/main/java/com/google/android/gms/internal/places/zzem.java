package com.google.android.gms.internal.places;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzem {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzw.zzeg),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzjr;

    private zzem(Object obj) {
        this.zzjr = obj;
    }
}
