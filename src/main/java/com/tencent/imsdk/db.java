package com.tencent.imsdk;

import com.tencent.imsdk.TIMFriendshipManager;

final class db implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30857a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30858b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManager.aa f30859c;

    db(TIMFriendshipManager.aa aaVar, int i, String str) {
        this.f30859c = aaVar;
        this.f30857a = i;
        this.f30858b = str;
    }

    public final void run() {
        this.f30859c.a(this.f30857a, this.f30858b);
    }
}
