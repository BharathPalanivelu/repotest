package com.tencent.qalsdk.util;

import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSRefreshUserSigListener;
import tencent.tls.platform.TLSUserInfo;

final class c implements TLSRefreshUserSigListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f32327a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ boolean f32328b;

    c(GuestHelper guestHelper, String str, boolean z) {
        this.f32327a = str;
        this.f32328b = z;
    }

    public final void OnRefreshUserSigFail(TLSErrInfo tLSErrInfo) {
        QLog.e("GuestHelper", 1, "OnRefreshUserSigFail:" + this.f32327a + ":" + this.f32328b);
    }

    public final void OnRefreshUserSigSuccess(TLSUserInfo tLSUserInfo) {
        QLog.i("GuestHelper", 1, "TLSRefreshUserSig succ:" + this.f32327a + ":" + this.f32328b);
        if (this.f32328b) {
            com.tencent.qalsdk.sdk.c.a().b(this.f32327a, new d(this));
        }
    }

    public final void OnRefreshUserSigTimeout(TLSErrInfo tLSErrInfo) {
        QLog.e("GuestHelper", 1, "OnRefreshUserSigTimeout:" + this.f32327a);
    }
}
