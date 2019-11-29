package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.TIMCallBack;

final class af extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMConversationExt f30985a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    af(TIMConversationExt tIMConversationExt, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f30985a = tIMConversationExt;
    }

    public final void onDone() {
        if (this.cb != null) {
            this.cb.onSuccess();
        }
    }

    public final void onFail(int i, String str) {
        if (this.cb != null) {
            this.cb.onError(i, str);
        }
    }
}
