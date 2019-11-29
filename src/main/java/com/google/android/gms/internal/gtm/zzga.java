package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tagmanager.zzck;

final class zzga extends zzck {
    final /* synthetic */ zzfy zzaqb;

    zzga(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j) throws RemoteException {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4);
        sb.append(str);
        sb.append("+gtm");
        this.zzaqb.zzamv.execute(new zzgb(this, str2, bundle, sb.toString(), j, str));
    }
}
