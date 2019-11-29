package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import java.util.ArrayList;
import java.util.List;

final class af extends TIMFriendshipManagerExt.ae<List<String>> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31026b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    af(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31026b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f31007a.onError(i, str);
    }

    public final void a(List<TIMFriendResult> list) {
        ArrayList arrayList = new ArrayList();
        for (TIMFriendResult identifer : list) {
            arrayList.add(identifer.getIdentifer());
        }
        this.f31007a.onSuccess(arrayList);
    }
}
