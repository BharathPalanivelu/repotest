package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import java.util.ArrayList;
import java.util.List;

final class aw extends TIMFriendshipManagerExt.ae<List<TIMFriendCheckResult>> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31043b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aw(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31043b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f31007a.onError(i, str);
    }

    public final void a(List<TIMFriendResult> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new TIMFriendCheckResult(list.get(i)));
        }
        this.f31007a.onSuccess(arrayList);
    }
}
