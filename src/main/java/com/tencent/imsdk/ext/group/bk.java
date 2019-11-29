package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30968a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30969b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ag f30970c;

    bk(TIMGroupManagerExt.ag agVar, int i, String str) {
        this.f30970c = agVar;
        this.f30968a = i;
        this.f30969b = str;
    }

    public final void run() {
        this.f30970c.a(this.f30968a, this.f30969b);
    }
}
