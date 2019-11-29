package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.zzbt;
import com.google.android.gms.internal.p000firebaseperf.zzda;

final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzda f14242a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzbt f14243b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c f14244c;

    e(c cVar, zzda zzda, zzbt zzbt) {
        this.f14244c = cVar;
        this.f14242a = zzda;
        this.f14243b = zzbt;
    }

    public final void run() {
        this.f14244c.b(this.f14242a, this.f14243b);
    }
}
