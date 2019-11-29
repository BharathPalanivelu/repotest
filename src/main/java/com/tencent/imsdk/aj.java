package com.tencent.imsdk;

final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30696a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30697b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreCallback f30698c;

    aj(IMCoreCallback iMCoreCallback, int i, String str) {
        this.f30698c = iMCoreCallback;
        this.f30696a = i;
        this.f30697b = str;
    }

    public final void run() {
        this.f30698c.onFail(this.f30696a, this.f30697b);
    }
}
