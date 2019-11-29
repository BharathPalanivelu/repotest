package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;

final class ar extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMUser f30721a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMCoreWrapper f30722b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ar(IMCoreWrapper iMCoreWrapper, TIMCallBack tIMCallBack, TIMUser tIMUser) {
        super(tIMCallBack);
        this.f30722b = iMCoreWrapper;
        this.f30721a = tIMUser;
    }

    public final void onDone() {
        QLog.e("imsdk.IMCoreWrapper", 1, "Login|4-InitIMCore|Succ|imcore init succ");
        IMCoreWrapper.get().setIMCoreUserInited(true);
        if (this.cb != null) {
            TIMCallBack tIMCallBack = this.cb;
            IMMsfUserInfo msfUserInfo = IMMsfCoreProxy.get().getMsfUserInfo(this.f30721a.getIdentifier());
            if (msfUserInfo == null || msfUserInfo.getUser() == null || msfUserInfo.getTinyid() == 0) {
                if (msfUserInfo != null) {
                    msfUserInfo.setIsLoggedIn(false);
                }
                IMMsfCoreProxy.loginErrOnMainthread(this.cb, BaseConstants.ERR_LOGGED_OUT_BEFORE_LOGIN_FINISHED, "logout explicitly or kicked off by other device");
                return;
            }
            IMCoreAndroidEnv.get().runOnMainThread((Runnable) new as(this, msfUserInfo, tIMCallBack));
            this.f30722b.loginSyncAndCacheCleanup(this.f30721a.getIdentifier());
        }
    }

    public final void onFail(int i, String str) {
        QLog.e("imsdk.IMCoreWrapper", 1, "Login|4-InitIMCore|Fail|imcore init failed! code: " + i + " desc: " + str);
        IMMsfCoreProxy.loginErrOnMainthread(this.cb, i, str);
    }
}
