package com.tencent.imsdk;

final class df extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupManager f30865a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    df(TIMGroupManager tIMGroupManager, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f30865a = tIMGroupManager;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
