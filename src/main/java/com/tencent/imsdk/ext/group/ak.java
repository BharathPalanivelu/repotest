package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class ak extends TIMGroupManagerExt.ae {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30924b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(TIMGroupManagerExt tIMGroupManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30924b = tIMGroupManagerExt;
    }

    public final void a(int i, String str) {
        this.f30891a.onError(i, str);
    }

    public final void a(TIMGroupMemberSucc tIMGroupMemberSucc) {
        this.f30891a.onSuccess(tIMGroupMemberSucc);
    }
}
