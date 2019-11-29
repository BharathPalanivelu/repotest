package com.google.firebase.remoteconfig;

import com.google.android.gms.internal.firebase_remote_config.zzfd;
import java.util.concurrent.Callable;

final /* synthetic */ class s implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final zzfd f14371a;

    private s(zzfd zzfd) {
        this.f14371a = zzfd;
    }

    static Callable a(zzfd zzfd) {
        return new s(zzfd);
    }

    public final Object call() {
        return Boolean.valueOf(this.f14371a.zzdg());
    }
}
