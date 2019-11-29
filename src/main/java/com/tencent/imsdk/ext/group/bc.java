package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30948a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30949b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ac f30950c;

    bc(TIMGroupManagerExt.ac acVar, int i, String str) {
        this.f30950c = acVar;
        this.f30948a = i;
        this.f30949b = str;
    }

    public final void run() {
        this.f30950c.a(this.f30948a, this.f30949b);
    }
}
