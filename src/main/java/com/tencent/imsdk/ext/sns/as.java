package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMValueCallBack;
import java.util.List;

final class as implements TIMValueCallBack<List<TIMFriendResult>> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f31039a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31040b;

    as(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMCallBack tIMCallBack) {
        this.f31040b = tIMFriendshipManagerExt;
        this.f31039a = tIMCallBack;
    }

    public final void onError(int i, String str) {
        this.f31039a.onError(i, str);
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        this.f31039a.onSuccess();
    }
}
