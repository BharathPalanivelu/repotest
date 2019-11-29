package com.tencent.imsdk;

import com.tencent.imsdk.TIMGroupManager;

final class dg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30866a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManager.aa f30867b;

    dg(TIMGroupManager.aa aaVar, String str) {
        this.f30867b = aaVar;
        this.f30866a = str;
    }

    public final void run() {
        this.f30867b.a(this.f30866a);
    }
}
