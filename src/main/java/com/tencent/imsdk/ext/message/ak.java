package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.TIMCallBack;

final class ak extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMConversationExt f30990a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(TIMConversationExt tIMConversationExt, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f30990a = tIMConversationExt;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
