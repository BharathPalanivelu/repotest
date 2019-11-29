package com.tencent.imsdk;

final class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30692a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30693b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ af f30694c;

    ah(af afVar, int i, String str) {
        this.f30694c = afVar;
        this.f30692a = i;
        this.f30693b = str;
    }

    public final void run() {
        this.f30694c.a(this.f30692a, this.f30693b);
    }
}
