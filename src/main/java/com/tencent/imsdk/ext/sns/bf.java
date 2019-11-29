package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f31053a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f31054b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.aa f31055c;

    bf(TIMFriendshipManagerExt.aa aaVar, int i, String str) {
        this.f31055c = aaVar;
        this.f31053a = i;
        this.f31054b = str;
    }

    public final void run() {
        this.f31055c.a(this.f31053a, this.f31054b);
    }
}
