package com.google.android.gms.internal.vision;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzfy {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzbo.zzgt),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzme;

    private zzfy(Object obj) {
        this.zzme = obj;
    }
}
