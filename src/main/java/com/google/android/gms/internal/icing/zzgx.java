package com.google.android.gms.internal.icing;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzgx {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzcl.zzfy),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzlh;

    private zzgx(Object obj) {
        this.zzlh = obj;
    }
}
