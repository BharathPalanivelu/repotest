package com.google.firebase.perf.internal;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f14253a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c f14254b;

    j(c cVar, boolean z) {
        this.f14254b = cVar;
        this.f14253a = z;
    }

    public final void run() {
        this.f14254b.b(this.f14253a);
    }
}
