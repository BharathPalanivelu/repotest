package com.tencent.imsdk;

import com.appsflyer.share.Constants;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import com.tencent.qalsdk.QALCallBack;
import com.tencent.qalsdk.QALSDKManager;
import java.util.Map;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSExchangeTicketListener;
import tencent.tls.platform.TLSLoginHelper;
import tencent.tls.platform.TLSUserInfo;

final class cn implements TLSExchangeTicketListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMUser f30831a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMMsfUserInfo f30832b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ QALCallBack f30833c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f30834d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ QualityReportHelper f30835e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30836f;

    cn(IMMsfCoreProxy iMMsfCoreProxy, TIMUser tIMUser, IMMsfUserInfo iMMsfUserInfo, QALCallBack qALCallBack, TIMCallBack tIMCallBack, QualityReportHelper qualityReportHelper) {
        this.f30836f = iMMsfCoreProxy;
        this.f30831a = tIMUser;
        this.f30832b = iMMsfUserInfo;
        this.f30833c = qALCallBack;
        this.f30834d = tIMCallBack;
        this.f30835e = qualityReportHelper;
    }

    public final void OnExchangeTicketFail(TLSErrInfo tLSErrInfo) {
        IMErrInfo iMErrInfo = new IMErrInfo(tLSErrInfo.ErrCode, tLSErrInfo.Msg);
        BaseConstants.covertErrorCode(iMErrInfo);
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Login|2-Ticket|Fail|OnExchangeTicketFail|code: " + iMErrInfo.getCode() + " desc: " + iMErrInfo.getMsg());
        IMMsfCoreProxy.loginErrOnMainthread(this.f30834d, iMErrInfo.getCode(), iMErrInfo.getMsg());
        this.f30835e.init(iMErrInfo.getCode(), iMErrInfo.getMsg());
        this.f30835e.report();
    }

    public final void OnExchangeTicketSuccess(TLSUserInfo tLSUserInfo) {
        try {
            Map<String, Object> sSOTicket = TLSLoginHelper.getInstance().getSSOTicket(this.f30831a.getIdentifier());
            this.f30832b.setTinyid(((Long) sSOTicket.get("tinyID")).longValue());
            QLog.w("imsdk.IMMsfCoreProxy", 1, "IMMsfCoreProxy|login update id:" + this.f30831a.getIdentifier() + Constants.URL_PATH_DELIMITER + sSOTicket.get("identifier").toString());
            TIMManager instanceById = TIMManager.getInstanceById(this.f30831a.getIdentifier());
            this.f30831a.setIdentifier(sSOTicket.get("identifier").toString());
            this.f30831a.setTinyId(this.f30832b.getTinyid());
            this.f30836f.mutiUserMap.put(this.f30831a.getIdentifier(), this.f30832b);
            instanceById.setIdentifier(this.f30831a.getIdentifier(), false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Login|2-Ticket|Succ|OnExchangeTicketSuccess, tinyid:" + this.f30832b.getTinyid());
        QALSDKManager.getInstance().bindID(tLSUserInfo.identifier, this.f30833c);
    }

    public final void OnExchangeTicketTimeout(TLSErrInfo tLSErrInfo) {
        IMErrInfo iMErrInfo = new IMErrInfo(tLSErrInfo.ErrCode, tLSErrInfo.Msg);
        BaseConstants.covertErrorCode(iMErrInfo);
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Login|2-Ticket|Fail|OnExchangeTicketTimeout|code:" + iMErrInfo.getCode() + " desc: " + iMErrInfo.getMsg());
        IMMsfCoreProxy.loginErrOnMainthread(this.f30834d, iMErrInfo.getCode(), iMErrInfo.getMsg());
        this.f30835e.init(iMErrInfo.getCode(), iMErrInfo.getMsg());
        this.f30835e.report();
    }
}
