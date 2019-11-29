package com.tencent.imsdk;

final class bw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30797a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ bu f30798b;

    bw(bu buVar, String str) {
        this.f30798b = buVar;
        this.f30797a = str;
    }

    public final void run() {
        this.f30798b.f30789a.onError(BaseConstants.ERR_HTTP_REQ_FAILED, this.f30797a);
    }
}
