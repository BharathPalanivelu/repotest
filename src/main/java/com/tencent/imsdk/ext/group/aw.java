package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.List;

final class aw extends TIMGroupManagerExt.aa {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30935b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aw(TIMGroupManagerExt tIMGroupManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30935b = tIMGroupManagerExt;
    }

    public final void a(int i, String str) {
        this.f30883a.onError(i, str);
    }

    public final void a(List<TIMGroupDetailInfo> list) {
        this.f30883a.onSuccess(list);
    }
}
