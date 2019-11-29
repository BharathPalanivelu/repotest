package com.tencent.imsdk;

import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.log.QLog;
import java.util.List;

final class cz extends TIMFriendshipManager.aa<List<TIMUserProfile>> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManager f30854b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cz(TIMFriendshipManager tIMFriendshipManager, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f30854b = tIMFriendshipManager;
    }

    public final void a(int i, String str) {
        this.f30671a.onError(i, str);
    }

    public final void a(List<TIMUserProfile> list) {
        for (TIMUserProfile next : list) {
            QLog.i("TIMFriendshipManager", 1, "get user profile: " + next.getIdentifier() + "nick: " + next.getNickName() + " face url: " + next.getFaceUrl());
        }
        this.f30671a.onSuccess(list);
    }
}
