package com.beetalk.sdk.ndk;

import com.beetalk.sdk.f;

public final class a {
    public static LoginRet a(f fVar) {
        LoginRet loginRet = new LoginRet();
        if (fVar != null) {
            loginRet.f5475c = fVar.m().getValue();
            loginRet.f5474b = fVar.h();
            if (!fVar.k()) {
                loginRet.f5473a = com.garena.pay.android.a.SUCCESS.getCode().intValue();
            } else {
                loginRet.f5473a = com.garena.pay.android.a.ACCESS_TOKEN_EXPIRED.getCode().intValue();
            }
            loginRet.f5476d.add(new c(b.f5478a, fVar.g().b(), (long) fVar.g().c()));
        } else {
            loginRet.f5475c = 0;
            loginRet.f5474b = "";
            loginRet.f5473a = com.garena.pay.android.a.ERROR.getCode().intValue();
        }
        return loginRet;
    }

    public static LoginRet b(f fVar) {
        LoginRet loginRet = new LoginRet();
        if (fVar != null) {
            loginRet.f5475c = fVar.m().getValue();
            loginRet.f5474b = fVar.h();
            if (fVar.k() || fVar.m() == f.b.GUEST) {
                loginRet.f5473a = com.garena.pay.android.a.BIND_FAILED.getCode().intValue();
            } else {
                loginRet.f5473a = com.garena.pay.android.a.SUCCESS.getCode().intValue();
            }
            loginRet.f5476d.add(new c(b.f5478a, fVar.g().b(), (long) fVar.g().c()));
        } else {
            loginRet.f5475c = 0;
            loginRet.f5474b = "";
            loginRet.f5473a = com.garena.pay.android.a.BIND_FAILED.getCode().intValue();
        }
        return loginRet;
    }
}
