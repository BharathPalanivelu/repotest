package com.shopee.app.network.c.h;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.network.a.a;
import com.shopee.app.network.c.c;
import com.shopee.app.network.c.h.f;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import com.shopee.protocol.action.ResponseLineLogin;
import d.d.b.j;

public final class e extends c implements a<ResponseCommon> {
    public int a() {
        return 249;
    }

    public Pair<String, ResponseCommon> a(byte[] bArr) {
        ResponseLineLogin responseLineLogin = (ResponseLineLogin) f.f18486a.parseFrom(bArr, 0, bArr != null ? bArr.length : 0, ResponseLineLogin.class);
        c(responseLineLogin.requestid);
        ResponseCommon build = new ResponseCommon.Builder().requestid(responseLineLogin.requestid).errcode(responseLineLogin.errcode).err_message(responseLineLogin.errmessage).token(responseLineLogin.token).userid(responseLineLogin.userid).shopid(responseLineLogin.shopid).country(responseLineLogin.country).acc(responseLineLogin.acc).timestamp(responseLineLogin.timestamp).build();
        Integer num = responseLineLogin.errcode;
        if (num != null && num.intValue() == 59) {
            b.a("LINE_LOGIN_REGISTER", new com.garena.android.appkit.b.a(responseLineLogin), b.a.NETWORK_BUS);
        } else if (num != null && num.intValue() == 0) {
            c().a(build, 3);
        } else {
            Integer num2 = responseLineLogin.errcode;
            j.a((Object) num2, "errcode");
            b.a("LINE_LOGIN_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(num2.intValue(), responseLineLogin.errmessage, build)), b.a.NETWORK_BUS);
        }
        return new Pair<>(responseLineLogin.requestid, build);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        c().a(builder.build());
    }

    private final f.a c() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        f.a newLoginProcessor = f2.e().newLoginProcessor();
        j.a((Object) newLoginProcessor, "ShopeeApplication.get().…     .newLoginProcessor()");
        return newLoginProcessor;
    }
}
