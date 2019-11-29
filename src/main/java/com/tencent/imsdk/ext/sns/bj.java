package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f31063a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f31064b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ac f31065c;

    bj(TIMFriendshipManagerExt.ac acVar, int i, String str) {
        this.f31065c = acVar;
        this.f31063a = i;
        this.f31064b = str;
    }

    public final void run() {
        this.f31065c.a(this.f31063a, this.f31064b);
    }
}
