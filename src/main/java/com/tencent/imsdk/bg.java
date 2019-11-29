package com.tencent.imsdk;

final class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30757a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30758b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ bf f30759c;

    bg(bf bfVar, int i, String str) {
        this.f30759c = bfVar;
        this.f30757a = i;
        this.f30758b = str;
    }

    public final void run() {
        if (this.f30759c.f30754a != null) {
            this.f30759c.f30754a.onError(this.f30757a, this.f30758b);
        }
    }
}
