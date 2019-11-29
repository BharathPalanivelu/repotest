package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class bm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30973a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30974b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ah f30975c;

    bm(TIMGroupManagerExt.ah ahVar, int i, String str) {
        this.f30975c = ahVar;
        this.f30973a = i;
        this.f30974b = str;
    }

    public final void run() {
        this.f30975c.a(this.f30973a, this.f30974b);
    }
}
