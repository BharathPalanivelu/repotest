package com.google.android.gms.internal.gtm;

import java.util.List;

final class zzdx implements Runnable {
    private final /* synthetic */ zzdq zzanc;
    private final zzmx zzane;

    zzdx(zzdq zzdq, zzmx zzmx) {
        this.zzanc = zzdq;
        this.zzane = zzmx;
    }

    public final void run() {
        zznm zzlq = this.zzane.zzll().zzlq();
        zznu zzlm = this.zzane.zzlm();
        boolean z = this.zzanc.zzamz == null;
        zzdq zzdq = this.zzanc;
        zzff unused = zzdq.zzamz = zzdq.zzamt.zza(zzlq, zzlm);
        int unused2 = this.zzanc.state = 2;
        String zzd = this.zzanc.zzaec;
        StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 48);
        sb.append("Container ");
        sb.append(zzd);
        sb.append(" loaded during runtime initialization.");
        zzev.zzab(sb.toString());
        if (this.zzanc.zzana != null) {
            for (zzee zzee : this.zzanc.zzana) {
                String valueOf = String.valueOf(zzee.zzkf());
                zzev.zzab(valueOf.length() != 0 ? "Evaluating tags for pending event ".concat(valueOf) : new String("Evaluating tags for pending event "));
                this.zzanc.zzamz.zzb(zzee);
            }
            List unused3 = this.zzanc.zzana = null;
        }
        this.zzanc.zzamz.dispatch();
        String valueOf2 = String.valueOf(this.zzanc.zzaec);
        zzev.zzab(valueOf2.length() != 0 ? "Runtime initialized successfully for container ".concat(valueOf2) : new String("Runtime initialized successfully for container "));
        long zzlr = this.zzane.zzll().zzlr() + this.zzanc.zzamy.zzhl();
        if (!z || !this.zzanc.zzanb || this.zzane.getSource() != 1 || zzlr >= this.zzanc.zzsd.currentTimeMillis()) {
            zzdq zzdq2 = this.zzanc;
            zzdq2.zzn(Math.max(900000, zzlr - zzdq2.zzsd.currentTimeMillis()));
            return;
        }
        zzdq zzdq3 = this.zzanc;
        zzdq3.zzn(zzdq3.zzamy.zzkd());
    }
}
