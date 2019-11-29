package com.tencent.imsdk;

import com.tencent.imsdk.TIMConversation;

final class cs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMConversation.aa f30843a;

    cs(TIMConversation.aa aaVar) {
        this.f30843a = aaVar;
    }

    public final void run() {
        this.f30843a.f30667a.onSuccess(this.f30843a.f30668b);
    }
}
