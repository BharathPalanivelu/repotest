package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.List;

public final class zzgy extends zzhb {
    private final String name;
    private zzfl zzape = null;
    private final List<String> zzarg;
    private final List<zzol> zzarh;

    public zzgy(zzfl zzfl, String str, List<String> list, List<zzol> list2) {
        this.name = str;
        this.zzarg = list;
        this.zzarh = list2;
    }

    public final void zza(zzfl zzfl) {
        this.zzape = zzfl;
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        try {
            zzfl zzku = this.zzape.zzku();
            for (int i = 0; i < this.zzarg.size(); i++) {
                if (zzoaArr.length > i) {
                    zzku.zza(this.zzarg.get(i), zzoaArr[i]);
                } else {
                    zzku.zza(this.zzarg.get(i), zzog.zzaum);
                }
            }
            zzku.zza("arguments", new zzoh(Arrays.asList(zzoaArr)));
            for (zzol zza : this.zzarh) {
                zzoa zza2 = zzoo.zza(zzku, zza);
                if ((zza2 instanceof zzog) && ((zzog) zza2).zzmh()) {
                    return (zzoa) ((zzog) zza2).value();
                }
            }
        } catch (RuntimeException e2) {
            String str = this.name;
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(message).length());
            sb.append("Internal error - Function call: ");
            sb.append(str);
            sb.append("\n");
            sb.append(message);
            zzev.zzav(sb.toString());
        }
        return zzog.zzaum;
    }

    public final String getName() {
        return this.name;
    }

    public final String toString() {
        String str = this.name;
        String obj = this.zzarg.toString();
        String obj2 = this.zzarh.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(obj).length() + String.valueOf(obj2).length());
        sb.append(str);
        sb.append("\n\tparams: ");
        sb.append(obj);
        sb.append("\n\t: statements: ");
        sb.append(obj2);
        return sb.toString();
    }
}
