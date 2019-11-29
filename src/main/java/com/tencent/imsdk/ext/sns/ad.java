package com.tencent.imsdk.ext.sns;

import java.util.List;

final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipProxyListener f31022a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ List f31023b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreFriendshipProxyCallback f31024c;

    ad(IMCoreFriendshipProxyCallback iMCoreFriendshipProxyCallback, TIMFriendshipProxyListener tIMFriendshipProxyListener, List list) {
        this.f31024c = iMCoreFriendshipProxyCallback;
        this.f31022a = tIMFriendshipProxyListener;
        this.f31023b = list;
    }

    public final void run() {
        this.f31022a.OnAddFriendReqs(this.f31023b);
    }
}
