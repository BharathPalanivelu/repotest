package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class ay implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30938a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30939b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.aa f30940c;

    ay(TIMGroupManagerExt.aa aaVar, int i, String str) {
        this.f30940c = aaVar;
        this.f30938a = i;
        this.f30939b = str;
    }

    public final void run() {
        this.f30940c.a(this.f30938a, this.f30939b);
    }
}
