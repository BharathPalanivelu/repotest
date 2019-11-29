package com.tencent.imsdk;

final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30800a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ bu f30801b;

    by(bu buVar, String str) {
        this.f30801b = buVar;
        this.f30800a = str;
    }

    public final void run() {
        this.f30801b.f30789a.onError(BaseConstants.ERR_IO_OPERATION_FAILED, this.f30800a);
    }
}
