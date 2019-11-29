package com.shopee.app.web2.b.c;

import android.content.Context;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.react.g;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.shopee.web.sdk.bridge.protocol.common.StatusResponse;
import com.shopee.web.sdk.bridge.protocol.login.LoginRequest;
import d.d.b.j;
import d.m;

public final class a extends com.shopee.web.sdk.bridge.a.d.a {

    /* renamed from: a  reason: collision with root package name */
    public UserInfo f26646a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((com.shopee.app.web2.b.a) b2).a(this);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web2.bridge.WebBridgeSdkInjector");
    }

    /* access modifiers changed from: protected */
    public void a(LoginRequest loginRequest) {
        if (loginRequest != null) {
            UserInfo userInfo = this.f26646a;
            if (userInfo == null) {
                j.b("userInfo");
            }
            if (userInfo.isLoggedIn()) {
                b(new StatusResponse(1));
                return;
            }
            g.a(loginRequest.getRedirectPath());
            if (loginRequest.getHidePopup() == 1) {
                AuthTabActivity_.a(f()).b(loginRequest.getRedirectTab()).a();
            } else {
                com.shopee.app.ui.dialog.a.a(f(), (int) R.string.sp_login_msg_web_action, 0);
            }
        }
    }
}
