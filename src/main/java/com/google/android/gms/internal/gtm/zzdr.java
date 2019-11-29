package com.google.android.gms.internal.gtm;

final class zzdr implements Runnable {
    private final /* synthetic */ zzdq zzanc;

    zzdr(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    public final void run() {
        if (this.zzanc.state == 2) {
            this.zzanc.zzamz.dispatch();
        }
    }
}
