package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupSearchSucc f30966a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ag f30967b;

    bj(TIMGroupManagerExt.ag agVar, TIMGroupSearchSucc tIMGroupSearchSucc) {
        this.f30967b = agVar;
        this.f30966a = tIMGroupSearchSucc;
    }

    public final void run() {
        this.f30967b.a(this.f30966a);
    }
}
