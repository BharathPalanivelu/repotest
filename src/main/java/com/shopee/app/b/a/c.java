package com.shopee.app.b.a;

import com.shopee.app.application.ar;
import com.shopee.navigator.c.a;

public class c extends com.shopee.navigator.c.a.c {
    public c(String str) {
        super(str);
    }

    public boolean a(a aVar) {
        return ar.f().e().loggedInUser().isLoggedIn() && super.a(aVar);
    }
}
