package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.f;
import com.google.firebase.remoteconfig.h;

public final class zzez implements f {
    private final long zzlt;
    private final int zzlu;
    private final h zzlv;

    private zzez(long j, int i, h hVar) {
        this.zzlt = j;
        this.zzlu = i;
        this.zzlv = hVar;
    }

    public final long getFetchTimeMillis() {
        return this.zzlt;
    }

    public final int getLastFetchStatus() {
        return this.zzlu;
    }

    public final h getConfigSettings() {
        return this.zzlv;
    }
}
