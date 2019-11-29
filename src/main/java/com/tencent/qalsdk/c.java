package com.tencent.qalsdk;

import com.tencent.qalsdk.util.QLog;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSExchangeTicketListener;
import tencent.tls.platform.TLSUserInfo;

final class c implements TLSExchangeTicketListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f32155a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ QALCallBack f32156b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ QALSDKManager f32157c;

    c(QALSDKManager qALSDKManager, String str, QALCallBack qALCallBack) {
        this.f32157c = qALSDKManager;
        this.f32155a = str;
        this.f32156b = qALCallBack;
    }

    public final void OnExchangeTicketFail(TLSErrInfo tLSErrInfo) {
        QLog.e("QALSDKManager", 1, "[TLSExchangeTicket] fail:" + this.f32155a + ":" + tLSErrInfo.ErrCode + ":" + tLSErrInfo.ExtraMsg);
        this.f32156b.onError(tLSErrInfo.ErrCode, tLSErrInfo.ExtraMsg);
    }

    public final void OnExchangeTicketSuccess(TLSUserInfo tLSUserInfo) {
        this.f32157c.bindID(tLSUserInfo.identifier, this.f32156b);
    }

    public final void OnExchangeTicketTimeout(TLSErrInfo tLSErrInfo) {
        this.f32156b.onError(tLSErrInfo.ErrCode, tLSErrInfo.ExtraMsg);
        QLog.e("QALSDKManager", 1, "[TLSExchangeTicket] Timeout:" + this.f32155a + ":" + tLSErrInfo.ErrCode + ":" + tLSErrInfo.ExtraMsg);
    }
}
