package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.TIMCallBack;

final class bo extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupPendencyItem f30977a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bo(TIMGroupPendencyItem tIMGroupPendencyItem, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f30977a = tIMGroupPendencyItem;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
