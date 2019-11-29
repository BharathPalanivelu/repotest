package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzoe extends zzoa<Double> {
    private static final Map<String, zzgz> zzaug;
    private Double zzauh;

    public zzoe(Double d2) {
        Preconditions.checkNotNull(d2);
        this.zzauh = d2;
    }

    public final boolean zzcp(String str) {
        return zzaug.containsKey(str);
    }

    public final zzgz zzcq(String str) {
        if (zzcp(str)) {
            return zzaug.get(str);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53);
        sb.append("Native Method ");
        sb.append(str);
        sb.append(" is not defined for type DoubleWrapper.");
        throw new IllegalStateException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzoe) {
            return this.zzauh.equals((Double) ((zzoe) obj).value());
        }
        return false;
    }

    public final String toString() {
        return this.zzauh.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzauh;
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        hashMap.put("toString", new zzkc());
        zzaug = Collections.unmodifiableMap(hashMap);
    }
}
