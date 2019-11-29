package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGetFriendFutureListSucc f31051a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.aa f31052b;

    be(TIMFriendshipManagerExt.aa aaVar, TIMGetFriendFutureListSucc tIMGetFriendFutureListSucc) {
        this.f31052b = aaVar;
        this.f31051a = tIMGetFriendFutureListSucc;
    }

    public final void run() {
        this.f31052b.a(this.f31051a);
    }
}
