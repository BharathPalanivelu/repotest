package com.shopee.app.i.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.react.protocol.PushData;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavigateMessage;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;
import com.shopee.sdk.modules.ui.navigator.a;
import com.shopee.sdk.modules.ui.navigator.b;
import com.shopee.sdk.modules.ui.navigator.options.JumpOption;
import com.shopee.sdk.modules.ui.navigator.options.PopOption;
import com.shopee.sdk.modules.ui.navigator.options.PushOption;

public class e implements b {
    public void a(Activity activity) {
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
    }

    public void a(Activity activity, o oVar, PopOption popOption) {
    }

    public void a(Activity activity, NavigationPath navigationPath) {
        b(activity, navigationPath, new o(), PushOption.a());
    }

    public void a(Activity activity, NavigationPath navigationPath, o oVar) {
        b(activity, navigationPath, oVar, PushOption.a());
    }

    public void a(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption) {
        b(activity, navigationPath, oVar, pushOption);
    }

    public void a(Activity activity, NavigationPath navigationPath, o oVar, JumpOption jumpOption) {
        if (!navigationPath.h()) {
            return;
        }
        if (!(activity instanceof c)) {
            int i = 67108864;
            if (!jumpOption.a()) {
                i = 603979776;
            }
            ((HomeActivity_.a) HomeActivity_.a(activity).k(i)).a(navigationPath.d()).a();
            return;
        }
        ((c) activity).d(navigationPath.d());
    }

    private void b(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption) {
        if (pushOption.b() >= 1) {
            pushOption.b(pushOption.b() - 1);
        } else {
            b(activity, navigationPath, oVar);
        }
    }

    private void b(Activity activity, NavigationPath navigationPath, o oVar) {
        if (navigationPath.f()) {
            activity.startActivityForResult(a.a((Context) activity, navigationPath.b(), oVar), 1021);
        } else if (navigationPath.e()) {
            NavigateMessage navigateMessage = (NavigateMessage) WebRegister.GSON.a((l) oVar, NavigateMessage.class);
            WebPageActivity_.a(activity).a(navigateMessage.getNavbarStr()).b(navigationPath.a()).f(navigateMessage.getConfig() != null ? navigateMessage.getConfig().toString() : null).d(navigateMessage.getTabsStr()).e(navigateMessage.getTabRightButtonStr()).b(navigateMessage.getPageType()).i(navigateMessage.getPopUpForBackButtonStr()).a(1021);
        } else if (navigationPath.g()) {
            com.shopee.app.react.d.b.a(activity, navigationPath.c(), new PushData(oVar.b("propsString") ? oVar.c("propsString").c() : oVar.toString()), "", 0, oVar.b("enterType") ? oVar.c("enterType").g() : 0);
        }
    }
}
