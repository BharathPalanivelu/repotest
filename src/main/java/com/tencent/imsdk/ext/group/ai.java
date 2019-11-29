package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMGroupMemberInfo;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.List;

final class ai extends TIMGroupManagerExt.ac {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30922b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ai(TIMGroupManagerExt tIMGroupManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30922b = tIMGroupManagerExt;
    }

    public final void a(int i, String str) {
        this.f30887a.onError(i, str);
    }

    public final void a(List<TIMGroupMemberInfo> list) {
        this.f30887a.onSuccess(list);
    }
}
