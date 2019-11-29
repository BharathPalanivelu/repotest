package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.TIMCallBack;

final class aj extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMConversationExt f30989a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(TIMConversationExt tIMConversationExt, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f30989a = tIMConversationExt;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
