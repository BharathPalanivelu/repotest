package com.tencent.imsdk;

import com.tencent.imsdk.TIMFriendshipManager;
import java.util.ArrayList;

final class da implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30855a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManager.aa f30856b;

    da(TIMFriendshipManager.aa aaVar, ArrayList arrayList) {
        this.f30856b = aaVar;
        this.f30855a = arrayList;
    }

    public final void run() {
        this.f30856b.a(this.f30855a);
    }
}
