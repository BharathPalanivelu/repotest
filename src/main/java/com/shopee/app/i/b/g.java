package com.shopee.app.i.b;

import com.facebook.react.ReactInstanceManager;
import com.shopee.sdk.modules.app.d.a;
import d.d.b.j;

public final class g implements a {
    public ReactInstanceManager a() {
        com.shopee.app.react.g a2 = com.shopee.app.react.g.a();
        j.a((Object) a2, "reactApp");
        if (a2.b()) {
            return a2.e().b();
        }
        return null;
    }
}
