package com.google.android.gms.internal.icing;

final class zzep implements zzeu {
    private zzeu[] zzma;

    zzep(zzeu... zzeuArr) {
        this.zzma = zzeuArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzeu zzb : this.zzma) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzev zzc(Class<?> cls) {
        for (zzeu zzeu : this.zzma) {
            if (zzeu.zzb(cls)) {
                return zzeu.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
