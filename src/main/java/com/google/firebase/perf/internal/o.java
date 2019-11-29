package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.zzbt;

final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GaugeManager f14262a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14263b;

    /* renamed from: c  reason: collision with root package name */
    private final zzbt f14264c;

    o(GaugeManager gaugeManager, String str, zzbt zzbt) {
        this.f14262a = gaugeManager;
        this.f14263b = str;
        this.f14264c = zzbt;
    }

    public final void run() {
        this.f14262a.zzd(this.f14263b, this.f14264c);
    }
}
