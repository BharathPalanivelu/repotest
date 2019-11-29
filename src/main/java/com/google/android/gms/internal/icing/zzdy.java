package com.google.android.gms.internal.icing;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzdy {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzcl.class, zzcl.class, zzcl.zzfy),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzlf;
    private final Class<?> zzlg;
    private final Object zzlh;

    private zzdy(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzlf = cls;
        this.zzlg = cls2;
        this.zzlh = obj;
    }

    public final Class<?> zzca() {
        return this.zzlg;
    }
}
