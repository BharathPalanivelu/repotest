package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.zzbt;

final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GaugeManager f14258a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14259b;

    /* renamed from: c  reason: collision with root package name */
    private final zzbt f14260c;

    m(GaugeManager gaugeManager, String str, zzbt zzbt) {
        this.f14258a = gaugeManager;
        this.f14259b = str;
        this.f14260c = zzbt;
    }

    public final void run() {
        this.f14258a.zze(this.f14259b, this.f14260c);
    }
}
