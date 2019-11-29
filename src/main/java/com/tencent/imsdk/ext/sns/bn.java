package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f31073a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f31074b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ae f31075c;

    bn(TIMFriendshipManagerExt.ae aeVar, int i, String str) {
        this.f31075c = aeVar;
        this.f31073a = i;
        this.f31074b = str;
    }

    public final void run() {
        this.f31075c.a(this.f31073a, this.f31074b);
    }
}
