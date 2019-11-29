package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import com.tencent.qalsdk.QALCallBack;

final class cl implements QALCallBack {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TIMUser f30825a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TIMCallBack f30826b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ IMMsfUserInfo f30827c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30828d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30829e;

    cl(IMMsfCoreProxy iMMsfCoreProxy, TIMUser tIMUser, TIMCallBack tIMCallBack, QualityReportHelper qualityReportHelper, IMMsfUserInfo iMMsfUserInfo) {
        this.f30829e = iMMsfCoreProxy;
        this.f30825a = tIMUser;
        this.f30826b = tIMCallBack;
        this.f30828d = qualityReportHelper;
        this.f30827c = iMMsfUserInfo;
    }

    public final void onError(int i, String str) {
        IMErrInfo iMErrInfo = new IMErrInfo(i, str);
        BaseConstants.covertErrorCode(iMErrInfo);
        if (iMErrInfo.getCode() == 6208) {
            this.f30829e.logout(this.f30825a.getIdentifier(), (TIMCallBack) null);
        }
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Login|3-Online|Fail|bindID failed, code: " + iMErrInfo.getCode() + ", desc: " + iMErrInfo.getMsg());
        IMMsfCoreProxy.loginErrOnMainthread(this.f30826b, iMErrInfo.getCode(), iMErrInfo.getMsg());
        this.f30828d.init(iMErrInfo.getCode(), iMErrInfo.getMsg());
        this.f30828d.report();
    }

    public final void onSuccess() {
        this.f30827c.setIsLoggedIn(true);
        this.f30829e.mutiUserMap.put(this.f30827c.getIdentifier(), this.f30827c);
        TIMNetworkStatus unused = this.f30829e.networkStatus = TIMNetworkStatus.TIM_NETWORK_STATUS_CONNECTED;
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Login|3-Online|Succ|bindID succ");
        if (this.f30829e.mode == 1) {
            IMCoreWrapper.get().initUser(this.f30829e.context, this.f30825a, this.f30826b);
        } else if (this.f30827c.getUser() == null || this.f30827c.getTinyid() == 0) {
            IMMsfUserInfo iMMsfUserInfo = this.f30827c;
            if (iMMsfUserInfo != null) {
                iMMsfUserInfo.setIsLoggedIn(false);
            }
            IMMsfCoreProxy.loginErrOnMainthread(this.f30826b, BaseConstants.ERR_LOGGED_OUT_BEFORE_LOGIN_FINISHED, "logout explicitly or kicked off by other device");
            this.f30828d.init(BaseConstants.ERR_LOGGED_OUT_BEFORE_LOGIN_FINISHED, "logout explicitly or kicked off by other device");
            this.f30828d.report();
        } else {
            IMMsfCoreProxy.mainHandler.post(new cm(this));
            this.f30828d.init(0, "");
            this.f30828d.report();
            this.f30828d.reportDeviceID();
        }
    }
}
