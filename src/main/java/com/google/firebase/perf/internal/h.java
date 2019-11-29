package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.zzbt;
import com.google.android.gms.internal.p000firebaseperf.zzci;

final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzci f14249a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzbt f14250b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c f14251c;

    h(c cVar, zzci zzci, zzbt zzbt) {
        this.f14251c = cVar;
        this.f14249a = zzci;
        this.f14250b = zzbt;
    }

    public final void run() {
        this.f14251c.b(this.f14249a, this.f14250b);
    }
}
