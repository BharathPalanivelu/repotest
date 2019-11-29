package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f31058a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f31059b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ab f31060c;

    bh(TIMFriendshipManagerExt.ab abVar, int i, String str) {
        this.f31060c = abVar;
        this.f31058a = i;
        this.f31059b = str;
    }

    public final void run() {
        this.f31060c.a(this.f31058a, this.f31059b);
    }
}
