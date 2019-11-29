package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30943a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30944b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ab f30945c;

    ba(TIMGroupManagerExt.ab abVar, int i, String str) {
        this.f30945c = abVar;
        this.f30943a = i;
        this.f30944b = str;
    }

    public final void run() {
        this.f30945c.a(this.f30943a, this.f30944b);
    }
}
