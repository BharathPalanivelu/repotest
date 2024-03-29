package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzgp;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class zzgl extends zzes {
    private final ExecutorService zzamv;
    private final zzcm zzamx;
    /* access modifiers changed from: private */
    public final Map<String, zzdq> zzaqs;
    /* access modifiers changed from: private */
    public final zzdy zzaqt;
    /* access modifiers changed from: private */
    public final Context zzrm;

    public zzgl(Context context, zzcm zzcm, zzcd zzcd) {
        this(context, zzcm, new zzdy(context, zzcm, zzcd), zzgp.zza.zzr(context));
    }

    @VisibleForTesting
    private zzgl(Context context, zzcm zzcm, zzdy zzdy, ExecutorService executorService) {
        this.zzaqs = new HashMap(1);
        Preconditions.checkNotNull(zzcm);
        this.zzamx = zzcm;
        this.zzaqt = zzdy;
        this.zzamv = executorService;
        this.zzrm = context;
    }

    public final void zzc(String str, String str2, String str3) throws RemoteException {
        zza(str, str2, str3, (zzeo) null);
    }

    public final void zza(String str, String str2, String str3, zzeo zzeo) throws RemoteException {
        this.zzamv.execute(new zzgm(this, str, str2, str3, zzeo));
    }

    public final void zzkm() throws RemoteException {
        this.zzaqs.clear();
    }

    public final void zza(String str, Bundle bundle, String str2, long j, boolean z) throws RemoteException {
        this.zzamv.execute(new zzgn(this, new zzee(str, bundle, str2, new Date(j), z, this.zzamx)));
    }

    public final void dispatch() {
        this.zzamv.execute(new zzgo(this));
    }
}
