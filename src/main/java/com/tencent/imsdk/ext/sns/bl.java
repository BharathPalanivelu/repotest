package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f31068a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f31069b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ad f31070c;

    bl(TIMFriendshipManagerExt.ad adVar, int i, String str) {
        this.f31070c = adVar;
        this.f31068a = i;
        this.f31069b = str;
    }

    public final void run() {
        this.f31070c.a(this.f31068a, this.f31069b);
    }
}
