package com.tencent.imsdk;

import com.tencent.imsdk.TIMConversation;

final class ct implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30844a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30845b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMConversation.aa f30846c;

    ct(TIMConversation.aa aaVar, int i, String str) {
        this.f30846c = aaVar;
        this.f30844a = i;
        this.f30845b = str;
    }

    public final void run() {
        this.f30846c.f30667a.onError(this.f30844a, this.f30845b);
    }
}
