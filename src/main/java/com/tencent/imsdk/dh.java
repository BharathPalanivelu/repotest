package com.tencent.imsdk;

import com.tencent.imsdk.TIMGroupManager;

final class dh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30868a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30869b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManager.aa f30870c;

    dh(TIMGroupManager.aa aaVar, int i, String str) {
        this.f30870c = aaVar;
        this.f30868a = i;
        this.f30869b = str;
    }

    public final void run() {
        this.f30870c.a(this.f30868a, this.f30869b);
    }
}
