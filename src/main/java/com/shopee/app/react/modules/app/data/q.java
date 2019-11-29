package com.shopee.app.react.modules.app.data;

import com.google.a.o;
import com.shopee.app.util.h.a;
import com.shopee.app.web.WebRegister;

public class q implements h {
    public boolean a(String str) {
        return "webBridgeLog".equals(str);
    }

    public String b(String str) {
        o oVar = new o();
        oVar.a("logs", WebRegister.GSON.a((Object) a.a()));
        return oVar.toString();
    }
}
