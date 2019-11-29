package com.google.android.gms.internal.icing;

import android.util.Log;

final class zzbq extends zzbo<Boolean> {
    zzbq(zzbp zzbp, String str, Boolean bool) {
        super(zzbp, str, bool, (zzbn) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzax.zzbt.matcher(str).matches()) {
                return true;
            }
            if (zzax.zzbu.matcher(str).matches()) {
                return false;
            }
        }
        String zzs = super.zzs();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzs).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(zzs);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
