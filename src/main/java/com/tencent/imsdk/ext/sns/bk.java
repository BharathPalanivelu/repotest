package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import java.util.ArrayList;

final class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f31066a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ad f31067b;

    bk(TIMFriendshipManagerExt.ad adVar, ArrayList arrayList) {
        this.f31067b = adVar;
        this.f31066a = arrayList;
    }

    public final void run() {
        this.f31067b.a(this.f31066a);
    }
}
