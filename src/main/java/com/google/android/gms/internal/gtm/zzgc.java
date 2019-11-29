package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import com.google.android.gms.tagmanager.zzch;

final class zzgc extends zzch {
    final /* synthetic */ zzfy zzaqb;

    zzgc(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        String str3 = str;
        if (!str.endsWith("+gtm")) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4);
            sb.append(str);
            sb.append("+gtm");
            this.zzaqb.zzamv.execute(new zzgd(this, str2, bundle, sb.toString(), j, str));
            return;
        }
    }
}
