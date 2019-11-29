package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGetFriendPendencyListSucc f31061a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ac f31062b;

    bi(TIMFriendshipManagerExt.ac acVar, TIMGetFriendPendencyListSucc tIMGetFriendPendencyListSucc) {
        this.f31062b = acVar;
        this.f31061a = tIMGetFriendPendencyListSucc;
    }

    public final void run() {
        this.f31062b.a(this.f31061a);
    }
}
