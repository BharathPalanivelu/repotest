package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.ext.message.TIMConversationExt;

final class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30993a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30994b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMConversationExt.GetMsgsListener f30995c;

    am(TIMConversationExt.GetMsgsListener getMsgsListener, int i, String str) {
        this.f30995c = getMsgsListener;
        this.f30993a = i;
        this.f30994b = str;
    }

    public final void run() {
        this.f30995c.callback.onError(this.f30993a, this.f30994b);
    }
}
