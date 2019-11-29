package com.shopee.app.react.modules.ui.share;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.google.a.o;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.g.h;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.ShareMessage;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    h f18982a;

    /* renamed from: b  reason: collision with root package name */
    ShareConfigStore f18983b;

    /* renamed from: c  reason: collision with root package name */
    UserInfo f18984c;

    public a(c cVar) {
        cVar.c().a(this);
    }

    public void a(Activity activity, String str, final Promise promise) {
        ShareMessage shareMessage = (ShareMessage) WebRegister.GSON.a(str, ShareMessage.class);
        this.f18982a.a(shareMessage, this.f18983b.getShareOptions(), this.f18983b, shareMessage.getShopID() == this.f18984c.getShopId(), new h.b() {
            public void a(o oVar) {
                if (oVar != null && promise != null) {
                    com.garena.android.appkit.d.a.b("OnShareCallback onReport promise.resolve %s", oVar.toString());
                    promise.resolve(oVar.toString());
                }
            }
        });
    }
}
