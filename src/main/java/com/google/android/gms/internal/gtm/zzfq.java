package com.google.android.gms.internal.gtm;

final class zzfq implements Runnable {
    private final /* synthetic */ zzfo zzapm;

    zzfq(zzfo zzfo) {
        this.zzapm = zzfo;
    }

    public final void run() {
        boolean unused = this.zzapm.zzapi = false;
        this.zzapm.zzapg.dispatch();
    }
}
