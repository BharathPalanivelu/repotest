package com.google.android.gms.internal.vision;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzcz {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzbo.class, zzbo.class, zzbo.zzgt),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzmc;
    private final Class<?> zzmd;
    private final Object zzme;

    private zzcz(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzmc = cls;
        this.zzmd = cls2;
        this.zzme = obj;
    }

    public final Class<?> zzch() {
        return this.zzmd;
    }
}
