package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

final class zzdw implements zzmp, Runnable {
    private final /* synthetic */ zzdq zzanc;

    private zzdw(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    public final void run() {
        Preconditions.checkState(this.zzanc.state == 2);
        if (!zzfd.zzkr().zzbw(this.zzanc.zzaec)) {
            String zzd = this.zzanc.zzaec;
            StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 24);
            sb.append("Refreshing container ");
            sb.append(zzd);
            sb.append("...");
            zzev.zzab(sb.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(0);
            this.zzanc.zzamu.zza(this.zzanc.zzaec, this.zzanc.zzams, this.zzanc.zzamr, arrayList, this, this.zzanc.zzamy);
        }
    }

    public final void zza(zzmx zzmx) {
        if (zzmx.getStatus() == Status.RESULT_SUCCESS) {
            String zzd = this.zzanc.zzaec;
            StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 47);
            sb.append("Refreshed container ");
            sb.append(zzd);
            sb.append(". Reinitializing runtime...");
            zzev.zzab(sb.toString());
            this.zzanc.zzamv.execute(new zzdx(this.zzanc, zzmx));
            return;
        }
        zzdq zzdq = this.zzanc;
        zzdq.zzn(zzdq.zzamy.zzhm());
    }

    /* synthetic */ zzdw(zzdq zzdq, zzdr zzdr) {
        this(zzdq);
    }
}
