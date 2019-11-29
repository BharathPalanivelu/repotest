package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupPendencyListGetSucc f30961a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.af f30962b;

    bh(TIMGroupManagerExt.af afVar, TIMGroupPendencyListGetSucc tIMGroupPendencyListGetSucc) {
        this.f30962b = afVar;
        this.f30961a = tIMGroupPendencyListGetSucc;
    }

    public final void run() {
        this.f30962b.a(this.f30961a);
    }
}
