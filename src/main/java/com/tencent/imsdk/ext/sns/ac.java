package com.tencent.imsdk.ext.sns;

import java.util.List;

final class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipProxyListener f31019a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ List f31020b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreFriendshipProxyCallback f31021c;

    ac(IMCoreFriendshipProxyCallback iMCoreFriendshipProxyCallback, TIMFriendshipProxyListener tIMFriendshipProxyListener, List list) {
        this.f31021c = iMCoreFriendshipProxyCallback;
        this.f31019a = tIMFriendshipProxyListener;
        this.f31020b = list;
    }

    public final void run() {
        this.f31019a.OnFriendProfileUpdate(this.f31020b);
    }
}
