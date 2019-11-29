package com.google.android.gms.internal.icing;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzca {
    public static <T> zzbx<T> zza(zzbx<T> zzbx) {
        if ((zzbx instanceof zzcc) || (zzbx instanceof zzbz)) {
            return zzbx;
        }
        if (zzbx instanceof Serializable) {
            return new zzbz(zzbx);
        }
        return new zzcc(zzbx);
    }

    public static <T> zzbx<T> zzc(@NullableDecl T t) {
        return new zzcb(t);
    }
}
