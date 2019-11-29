package com.tencent.imsdk;

final class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30795a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ bu f30796b;

    bv(bu buVar, String str) {
        this.f30796b = buVar;
        this.f30795a = str;
    }

    public final void run() {
        this.f30796b.f30789a.onError(BaseConstants.ERR_HTTP_REQ_FAILED, this.f30795a);
    }
}
