package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Field;
import java.util.Map;

public final class zzbn {
    private final Map<String, zzbm> zzei = new zzbl();
    private final Map<Field, zzbm> zzej = new zzbl();
    private final Object zzek;

    public zzbn(Object obj) {
        this.zzek = obj;
    }

    public final void zzbu() {
        for (Map.Entry next : this.zzei.entrySet()) {
            ((Map) this.zzek).put((String) next.getKey(), ((zzbm) next.getValue()).zzbt());
        }
        for (Map.Entry next2 : this.zzej.entrySet()) {
            zzbz.zza((Field) next2.getKey(), this.zzek, ((zzbm) next2.getValue()).zzbt());
        }
    }

    public final void zza(Field field, Class<?> cls, Object obj) {
        zzbm zzbm = this.zzej.get(field);
        if (zzbm == null) {
            zzbm = new zzbm(cls);
            this.zzej.put(field, zzbm);
        }
        if (cls == zzbm.zzeg) {
            zzbm.zzeh.add(obj);
            return;
        }
        throw new IllegalArgumentException();
    }
}
