package com.tencent.imsdk;

final class cx extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManager f30851a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cx(TIMFriendshipManager tIMFriendshipManager, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f30851a = tIMFriendshipManager;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
