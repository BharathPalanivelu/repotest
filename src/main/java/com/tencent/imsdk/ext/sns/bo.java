package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMUserSearchSucc f31076a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.af f31077b;

    bo(TIMFriendshipManagerExt.af afVar, TIMUserSearchSucc tIMUserSearchSucc) {
        this.f31077b = afVar;
        this.f31076a = tIMUserSearchSucc;
    }

    public final void run() {
        this.f31077b.a(this.f31076a);
    }
}
