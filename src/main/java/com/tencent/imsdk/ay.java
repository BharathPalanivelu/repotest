package com.tencent.imsdk;

final class ay implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMErrInfo f30737a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ ax f30738b;

    ay(ax axVar, IMErrInfo iMErrInfo) {
        this.f30738b = axVar;
        this.f30737a = iMErrInfo;
    }

    public final void run() {
        this.f30738b.f30735a.onError(this.f30737a.getCode(), this.f30737a.getMsg());
    }
}
