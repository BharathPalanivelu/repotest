package com.shopee.app.network.d.d.a;

import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.network.d.d.a;
import com.shopee.protocol.search.action.RequestHeader;

public abstract class b extends a {

    /* renamed from: a  reason: collision with root package name */
    protected UserInfo f18255a = ar.f().e().loggedInUser();

    protected b() {
    }

    /* access modifiers changed from: protected */
    public RequestHeader e() {
        RequestHeader.Builder sessionid = new RequestHeader.Builder().country("ID").userid(Integer.valueOf(this.f18255a.getUserId())).shopid(Integer.valueOf(this.f18255a.getShopId())).sessionid(this.f18255a.getUsername());
        return sessionid.source("android/" + com.shopee.app.react.modules.app.appmanager.a.c()).requestid(i().a()).platform(4).build();
    }
}
