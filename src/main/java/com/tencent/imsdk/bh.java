package com.tencent.imsdk;

final class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMErrInfo f30760a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ bf f30761b;

    bh(bf bfVar, IMErrInfo iMErrInfo) {
        this.f30761b = bfVar;
        this.f30760a = iMErrInfo;
    }

    public final void run() {
        if (this.f30761b.f30754a != null) {
            this.f30761b.f30754a.onError(this.f30760a.getCode(), this.f30760a.getMsg());
        }
    }
}
