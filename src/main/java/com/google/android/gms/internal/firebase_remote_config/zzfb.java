package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.h;

public final class zzfb {
    private long zzlw;
    private int zzlx;
    private h zzly;

    private zzfb() {
    }

    public final zzfb zzc(long j) {
        this.zzlw = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzfb zzn(int i) {
        this.zzlx = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzfb zzc(h hVar) {
        this.zzly = hVar;
        return this;
    }

    public final zzez zzdf() {
        return new zzez(this.zzlw, this.zzlx, this.zzly);
    }
}
