package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.List;

final class ap extends TIMGroupManagerExt.ad {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30929b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ap(TIMGroupManagerExt tIMGroupManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30929b = tIMGroupManagerExt;
    }

    public final void a(int i, String str) {
        this.f30889a.onError(i, str);
    }

    public final void a(List<TIMGroupMemberResult> list) {
        this.f30889a.onSuccess(list);
    }
}
