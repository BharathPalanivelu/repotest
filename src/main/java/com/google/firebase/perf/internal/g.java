package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.zzbt;
import com.google.android.gms.internal.p000firebaseperf.zzcd;

final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzcd f14246a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzbt f14247b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c f14248c;

    g(c cVar, zzcd zzcd, zzbt zzbt) {
        this.f14248c = cVar;
        this.f14246a = zzcd;
        this.f14247b = zzbt;
    }

    public final void run() {
        this.f14248c.b(this.f14246a, this.f14247b);
    }
}
