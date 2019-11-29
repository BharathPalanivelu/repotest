package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30953a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30954b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ad f30955c;

    be(TIMGroupManagerExt.ad adVar, int i, String str) {
        this.f30955c = adVar;
        this.f30953a = i;
        this.f30954b = str;
    }

    public final void run() {
        this.f30955c.a(this.f30953a, this.f30954b);
    }
}
