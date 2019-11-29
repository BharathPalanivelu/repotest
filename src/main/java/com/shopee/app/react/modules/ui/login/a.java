package com.shopee.app.react.modules.ui.login;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.shopee.app.react.g;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.LoginMessage;

public class a extends b {
    public void a(Activity activity, String str, Promise promise) {
        LoginMessage loginMessage = (LoginMessage) WebRegister.GSON.a(str, LoginMessage.class);
        if (!activity.isFinishing()) {
            g.a(loginMessage.getRedirectPath());
            AuthTabActivity_.a(activity).b(loginMessage.getRedirectTab()).b(loginMessage.getAcquisitionSource()).a();
        }
    }
}
