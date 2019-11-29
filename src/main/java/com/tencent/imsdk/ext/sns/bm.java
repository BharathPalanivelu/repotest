package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import java.util.ArrayList;

final class bm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f31071a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ae f31072b;

    bm(TIMFriendshipManagerExt.ae aeVar, ArrayList arrayList) {
        this.f31072b = aeVar;
        this.f31071a = arrayList;
    }

    public final void run() {
        this.f31072b.a(this.f31071a);
    }
}
