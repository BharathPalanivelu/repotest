package com.google.android.gms.internal.gtm;

import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.litesuits.orm.db.assit.SQLBuilder;

public final class zzld implements zzgz {
    private final String zzarr = Build.MANUFACTURER;
    private final String zzars = Build.MODEL;

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = false;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length == 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        String str = this.zzarr;
        String str2 = this.zzars;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
            sb.append(str);
            sb.append(SQLBuilder.BLANK);
            sb.append(str2);
            str2 = sb.toString();
        }
        return new zzom(str2);
    }
}
