package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.ext.message.TIMConversationExt;
import java.util.ArrayList;

final class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30991a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMConversationExt.GetMsgsListener f30992b;

    al(TIMConversationExt.GetMsgsListener getMsgsListener, ArrayList arrayList) {
        this.f30992b = getMsgsListener;
        this.f30991a = arrayList;
    }

    public final void run() {
        this.f30992b.callback.onSuccess(this.f30991a);
    }
}
