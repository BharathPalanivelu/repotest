package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupMemberSucc f30956a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ae f30957b;

    bf(TIMGroupManagerExt.ae aeVar, TIMGroupMemberSucc tIMGroupMemberSucc) {
        this.f30957b = aeVar;
        this.f30956a = tIMGroupMemberSucc;
    }

    public final void run() {
        this.f30957b.a(this.f30956a);
    }
}
