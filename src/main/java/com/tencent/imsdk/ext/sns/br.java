package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class br implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f31082a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f31083b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ag f31084c;

    br(TIMFriendshipManagerExt.ag agVar, int i, String str) {
        this.f31084c = agVar;
        this.f31082a = i;
        this.f31083b = str;
    }

    public final void run() {
        this.f31084c.a(this.f31082a, this.f31083b);
    }
}
