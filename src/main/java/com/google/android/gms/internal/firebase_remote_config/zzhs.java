package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzhs {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzfx.class, zzfx.class, zzfx.zzov),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzuo;
    private final Class<?> zzup;
    private final Object zzuq;

    private zzhs(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzuo = cls;
        this.zzup = cls2;
        this.zzuq = obj;
    }

    public final Class<?> zzho() {
        return this.zzup;
    }
}
