package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import com.tencent.imsdk.log.QLog;
import java.util.List;

final class ax extends TIMFriendshipManagerExt.ad<List<TIMUserProfile>> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31044b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ax(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31044b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f31005a.onError(i, str);
    }

    public final void a(List<TIMUserProfile> list) {
        for (TIMUserProfile next : list) {
            QLog.i("TIMFriendshipManager", 1, "get friend profile: " + next.getIdentifier() + "nick: " + next.getNickName() + " face url: " + next.getFaceUrl());
        }
        this.f31005a.onSuccess(list);
    }
}
