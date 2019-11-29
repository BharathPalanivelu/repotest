package com.tencent.imsdk;

final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30775a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30776b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ bm f30777c;

    bn(bm bmVar, int i, String str) {
        this.f30777c = bmVar;
        this.f30775a = i;
        this.f30776b = str;
    }

    public final void run() {
        this.f30777c.f30772a.onError(this.f30775a, this.f30776b);
    }
}
