package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzol extends zzoa<String> {
    private final String zzauu;
    private final List<zzoa<?>> zzauv;

    public zzol(String str, List<zzoa<?>> list) {
        Preconditions.checkNotNull(str, "Instruction name must be a string.");
        Preconditions.checkNotNull(list);
        this.zzauu = str;
        this.zzauv = list;
    }

    public final String toString() {
        String str = this.zzauu;
        String obj = this.zzauv.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(obj).length());
        sb.append("*");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        return sb.toString();
    }

    public final String zzmj() {
        return this.zzauu;
    }

    public final List<zzoa<?>> zzmk() {
        return this.zzauv;
    }

    public final /* synthetic */ Object value() {
        return toString();
    }
}
