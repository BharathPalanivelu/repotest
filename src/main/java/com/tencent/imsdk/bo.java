package com.tencent.imsdk;

final class bo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMErrInfo f30778a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ bm f30779b;

    bo(bm bmVar, IMErrInfo iMErrInfo) {
        this.f30779b = bmVar;
        this.f30778a = iMErrInfo;
    }

    public final void run() {
        this.f30779b.f30772a.onError(this.f30778a.getCode(), this.f30778a.getMsg());
    }
}
