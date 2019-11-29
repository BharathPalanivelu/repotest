package com.tencent.imsdk;

import java.util.List;

final class cy implements TIMValueCallBack<List<TIMUserProfile>> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMValueCallBack f30852a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManager f30853b;

    cy(TIMFriendshipManager tIMFriendshipManager, TIMValueCallBack tIMValueCallBack) {
        this.f30853b = tIMFriendshipManager;
        this.f30852a = tIMValueCallBack;
    }

    public final void onError(int i, String str) {
        this.f30852a.onError(i, str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        List list = (List) obj;
        if (list.isEmpty()) {
            this.f30852a.onSuccess(new TIMUserProfile());
        } else {
            this.f30852a.onSuccess(list.get(0));
        }
    }
}
