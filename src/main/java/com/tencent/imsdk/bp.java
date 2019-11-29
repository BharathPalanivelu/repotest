package com.tencent.imsdk;

final class bp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMOfflinePushSettings f30780a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ bm f30781b;

    bp(bm bmVar, TIMOfflinePushSettings tIMOfflinePushSettings) {
        this.f30781b = bmVar;
        this.f30780a = tIMOfflinePushSettings;
    }

    public final void run() {
        this.f30781b.f30772a.onSuccess(this.f30780a);
    }
}
