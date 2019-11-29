package com.tencent.imsdk;

import java.util.List;

final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ List f30690a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ af f30691b;

    ag(af afVar, List list) {
        this.f30691b = afVar;
        this.f30690a = list;
    }

    public final void run() {
        this.f30691b.a(this.f30690a);
    }
}
