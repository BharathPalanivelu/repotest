package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class au extends TIMGroupManagerExt.ag {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30934b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    au(TIMGroupManagerExt tIMGroupManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30934b = tIMGroupManagerExt;
    }

    public final void a(int i, String str) {
        this.f30895a.onError(i, str);
    }

    public final void a(TIMGroupSearchSucc tIMGroupSearchSucc) {
        this.f30895a.onSuccess(tIMGroupSearchSucc);
    }
}
