package com.tencent.imsdk;

final class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30762a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30763b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ bf f30764c;

    bi(bf bfVar, int i, String str) {
        this.f30764c = bfVar;
        this.f30762a = i;
        this.f30763b = str;
    }

    public final void run() {
        if (this.f30764c.f30754a != null) {
            this.f30764c.f30754a.onError(this.f30762a, this.f30763b);
        }
    }
}
