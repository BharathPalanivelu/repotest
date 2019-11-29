package com.tencent.imsdk.ext.sns;

import java.util.List;

final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipProxyListener f31013a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ List f31014b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreFriendshipProxyCallback f31015c;

    aa(IMCoreFriendshipProxyCallback iMCoreFriendshipProxyCallback, TIMFriendshipProxyListener tIMFriendshipProxyListener, List list) {
        this.f31015c = iMCoreFriendshipProxyCallback;
        this.f31013a = tIMFriendshipProxyListener;
        this.f31014b = list;
    }

    public final void run() {
        this.f31013a.OnAddFriends(this.f31014b);
    }
}
