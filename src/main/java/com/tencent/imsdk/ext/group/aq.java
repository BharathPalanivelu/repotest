package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.List;

final class aq extends TIMGroupManagerExt.ab {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30930b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aq(TIMGroupManagerExt tIMGroupManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30930b = tIMGroupManagerExt;
    }

    public final void a(int i, String str) {
        this.f30885a.onError(i, str);
    }

    public final void a(List<TIMGroupBaseInfo> list) {
        this.f30885a.onSuccess(list);
    }
}
