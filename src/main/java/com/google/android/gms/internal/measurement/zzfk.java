package com.google.android.gms.internal.measurement;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzfk {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdp.class, zzdp.class, zzdp.zzadh),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzajh;
    private final Class<?> zzaji;
    private final Object zzajj;

    private zzfk(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzajh = cls;
        this.zzaji = cls2;
        this.zzajj = obj;
    }

    public final Class<?> zzvd() {
        return this.zzaji;
    }
}
