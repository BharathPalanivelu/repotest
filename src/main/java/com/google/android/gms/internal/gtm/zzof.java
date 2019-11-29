package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzof extends zzoa<zzgz> {
    private static final Map<String, zzgz> zzaug;
    private zzgz zzaui;

    public zzof(zzgz zzgz) {
        this.zzaui = zzgz;
    }

    public final Iterator<zzoa<?>> zzmf() {
        return zzmg();
    }

    public final boolean zzcp(String str) {
        return zzaug.containsKey(str);
    }

    public final zzgz zzcq(String str) {
        if (zzcp(str)) {
            return zzaug.get(str);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 60);
        sb.append("Native Method ");
        sb.append(str);
        sb.append(" is not defined for type InstructionReference.");
        throw new IllegalStateException(sb.toString());
    }

    public final String toString() {
        return this.zzaui.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzaui;
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        zzaug = Collections.unmodifiableMap(hashMap);
    }
}
