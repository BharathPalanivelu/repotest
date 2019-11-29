package com.shopee.app.web2.a;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.util.bm;
import com.shopee.app.util.i;
import com.shopee.app.web2.d;

public class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private final UserInfo f26622a;

    public e(UserInfo userInfo) {
        this.f26622a = userInfo;
    }

    public void a() {
        d c2 = c();
        if (c2 != null) {
            WebPageModel webPageModel = c2.f26664a;
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            instance.setCookie(webPageModel.getUrl(), "userid=" + this.f26622a.getUserId() + "; shopid=" + this.f26622a.getShopId() + "; shopee_token=" + this.f26622a.getToken() + "; domain=" + i.f7042e + "; path=/;");
            instance.setCookie(webPageModel.getUrl(), "shopee_token=" + this.f26622a.getToken() + "; domain=" + i.f7042e + "; path=/;");
            instance.setCookie(webPageModel.getUrl(), "username=" + this.f26622a.getUsername() + "; domain=" + i.f7042e + "; path=/;");
            instance.setCookie(webPageModel.getUrl(), "UA=" + bm.a(c2.n) + "; domain=" + i.f7042e + "; path=/;");
            CookieSyncManager.getInstance().sync();
        }
    }
}
