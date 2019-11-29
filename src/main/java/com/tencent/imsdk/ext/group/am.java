package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class am extends TIMGroupManagerExt.af {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30926b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    am(TIMGroupManagerExt tIMGroupManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30926b = tIMGroupManagerExt;
    }

    public final void a(int i, String str) {
        this.f30893a.onError(i, str);
    }

    public final void a(TIMGroupPendencyListGetSucc tIMGroupPendencyListGetSucc) {
        this.f30893a.onSuccess(tIMGroupPendencyListGetSucc);
    }
}
