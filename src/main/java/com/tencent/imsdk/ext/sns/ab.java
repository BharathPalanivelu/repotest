package com.tencent.imsdk.ext.sns;

import java.util.List;

final class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipProxyListener f31016a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ List f31017b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreFriendshipProxyCallback f31018c;

    ab(IMCoreFriendshipProxyCallback iMCoreFriendshipProxyCallback, TIMFriendshipProxyListener tIMFriendshipProxyListener, List list) {
        this.f31018c = iMCoreFriendshipProxyCallback;
        this.f31016a = tIMFriendshipProxyListener;
        this.f31017b = list;
    }

    public final void run() {
        this.f31016a.OnDelFriends(this.f31017b);
    }
}
