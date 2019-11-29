package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.List;

final class al extends TIMGroupManagerExt.ah<TIMGroupSelfInfo> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30925b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    al(TIMGroupManagerExt tIMGroupManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30925b = tIMGroupManagerExt;
    }

    public final void a(int i, String str) {
        this.f30897a.onError(i, str);
    }

    public final void a(List<TIMGroupSelfInfo> list) {
        this.f30897a.onSuccess(list.get(0));
    }
}
