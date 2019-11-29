package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ag f31081a;

    bq(TIMFriendshipManagerExt.ag agVar) {
        this.f31081a = agVar;
    }

    public final void run() {
        this.f31081a.a();
    }
}
