package com.tencent.qalsdk.util;

import com.tencent.qalsdk.sdk.c;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSSSOGuestLoginListener;
import tencent.tls.platform.TLSUserInfo;

final class e implements TLSSSOGuestLoginListener {
    e(GuestHelper guestHelper) {
    }

    public final void OnGuestLoginFail(TLSErrInfo tLSErrInfo) {
        QLog.e("GuestHelper", 1, "OnGuestLoginFail:" + tLSErrInfo.ErrCode + ":" + tLSErrInfo.Msg);
    }

    public final void OnGuestLoginSuccess(TLSUserInfo tLSUserInfo) {
        c.a().a(tLSUserInfo.identifier);
        QLog.d("GuestHelper", 1, "OnGuestLoginSuccess:" + tLSUserInfo.identifier);
        c.a().b(tLSUserInfo.identifier, new f(this));
    }

    public final void OnGuestLoginTimeout(TLSErrInfo tLSErrInfo) {
        QLog.e("GuestHelper", 1, "OnGuestLoginTimeout:" + tLSErrInfo.ErrCode + ":" + tLSErrInfo.Msg);
    }
}
