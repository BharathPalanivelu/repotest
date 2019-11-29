package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f31078a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f31079b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.af f31080c;

    bp(TIMFriendshipManagerExt.af afVar, int i, String str) {
        this.f31080c = afVar;
        this.f31078a = i;
        this.f31079b = str;
    }

    public final void run() {
        this.f31080c.a(this.f31078a, this.f31079b);
    }
}
