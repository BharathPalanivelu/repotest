package com.shopee.app.web2.b.d;

import android.content.Context;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.util.x;
import com.shopee.app.web2.WebPageActivity2_;
import com.shopee.app.web2.b.a;
import com.shopee.navigator.e;
import com.shopee.web.sdk.bridge.a.e.b;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;
import com.shopee.web.sdk.bridge.protocol.navigation.NavigateRequest;
import d.d.b.j;
import d.m;

public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public e f26648a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((a) b2).a(this);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web2.bridge.WebBridgeSdkInjector");
    }

    /* access modifiers changed from: protected */
    public void a(NavigateRequest navigateRequest) {
        int i;
        if (navigateRequest != null) {
            ConfigurePageRequest.ConfigMessage configMessage = (ConfigurePageRequest.ConfigMessage) com.shopee.web.sdk.bridge.internal.a.f30470a.a(navigateRequest.getConfig(), ConfigurePageRequest.ConfigMessage.class);
            if (configMessage != null) {
                i = configMessage.getWebviewType();
            } else {
                i = 0;
            }
            String str = null;
            if (i != 0) {
                WebPageActivity2_.a b2 = WebPageActivity2_.a(f()).a(navigateRequest.getNavbarStr()).b(navigateRequest.getUrl());
                if (configMessage != null) {
                    str = configMessage.toString();
                }
                b2.d(str).a();
                return;
            }
            WebPageActivity_.a b3 = WebPageActivity_.a(f()).a(navigateRequest.getNavbarStr()).b(navigateRequest.getUrl());
            if (configMessage != null) {
                str = configMessage.toString();
            }
            b3.f(str).d(navigateRequest.getTabsStr()).e(navigateRequest.getTabRightButtonStr()).i(navigateRequest.getPopUpForBackButtonStr()).a();
        }
    }
}
