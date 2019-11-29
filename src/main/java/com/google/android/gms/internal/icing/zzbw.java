package com.google.android.gms.internal.icing;

import java.io.Serializable;

public abstract class zzbw<T> implements Serializable {
    public static <T> zzbw<T> zzv() {
        return zzbu.zzdq;
    }

    public abstract T get();

    public abstract boolean isPresent();

    public static <T> zzbw<T> zzb(T t) {
        return new zzby(zzbv.checkNotNull(t));
    }

    zzbw() {
    }
}
