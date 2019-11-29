package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum ns {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(kc.f12862a),
    ENUM((String) null),
    MESSAGE((String) null);

    private ns(Object obj) {
    }
}
