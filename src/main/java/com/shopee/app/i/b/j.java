package com.shopee.app.i.b;

import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.sdk.modules.app.e.a;
import com.shopee.sdk.modules.app.e.b;

public class j implements b {
    public a a() {
        UserInfo c2 = c();
        return new a.C0471a().a(c2.getToken()).a(c2.getUserId()).b(c2.getShopId()).b(c2.getUsername()).c(c2.getAvatarId()).d(c2.getPortrait()).e(c2.getNickname()).a();
    }

    public boolean b() {
        return c().isLoggedIn();
    }

    private UserInfo c() {
        return ar.f().e().loggedInUser();
    }
}
