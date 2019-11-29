package com.shopee.app.react.modules.ui.navigator;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.react.protocol.PopData;
import com.shopee.app.react.protocol.PushData;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.util.aj;
import com.shopee.app.util.ak;
import com.shopee.app.util.aw;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavigateMessage;
import com.shopee.app.web.protocol.PathData;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    b.a<com.shopee.app.util.l.b> f18923a;

    /* renamed from: b  reason: collision with root package name */
    b.a<aw> f18924b;

    /* renamed from: c  reason: collision with root package name */
    b.a<ak> f18925c;

    public a(c cVar) {
        cVar.c().a(this);
    }

    public void a(Activity activity, String str, String str2, int i, String str3) {
        Intent intent = new Intent(activity, com.shopee.app.react.d.b.a(i));
        intent.putExtra("bundleName", str);
        intent.putExtra("moduleName", str2);
        intent.putExtra("pushData", str3);
        intent.putExtra("enterType", i);
        int i2 = 0;
        if (!TextUtils.isEmpty(str3)) {
            try {
                PushData pushData = (PushData) WebRegister.GSON.a(str3, PushData.class);
                if (pushData != null) {
                    i2 = pushData.getPopCount();
                }
            } catch (Exception unused) {
            }
        }
        if (i2 == 0) {
            activity.startActivityForResult(intent, 11028);
            aj.a(activity, i);
            return;
        }
        a(activity, intent, i2);
    }

    public void a(Activity activity, Intent intent, int i) {
        int i2 = i - 1;
        if (i2 > 0) {
            intent.putExtra("pop_count", i2);
            activity.setResult(13397, intent);
        } else {
            intent.setFlags(33554432);
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
        }
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    public void a(Activity activity, String str) {
        a(activity, (PopData) WebRegister.GSON.a(str, PopData.class));
    }

    public void a(Activity activity, String str, String str2) {
        this.f18923a.get().a(str, str2);
    }

    public void b(Activity activity, String str) {
        NavigateMessage navigateMessage = (NavigateMessage) WebRegister.GSON.a(str, NavigateMessage.class);
        if (!TextUtils.isEmpty(navigateMessage.getBackUrl())) {
            c(activity, WebRegister.GSON.b((Object) new PathData(navigateMessage.getBackUrl())));
        }
        String str2 = null;
        if (navigateMessage.getConfig() != null) {
            str2 = navigateMessage.getConfig().toString();
        }
        String preloadKey = navigateMessage.getPreloadKey();
        boolean z = navigateMessage.getPresentModal() == 1;
        if (TextUtils.isEmpty(str2)) {
            WebPageActivity_.a(activity).a(navigateMessage.getNavbarStr()).b(navigateMessage.getUrl()).a(z).d(navigateMessage.getTabsStr()).e(navigateMessage.getTabRightButtonStr()).i(navigateMessage.getPopUpForBackButtonStr()).h(preloadKey).a(100);
        } else {
            WebPageActivity_.a(activity).a(navigateMessage.getNavbarStr()).b(navigateMessage.getUrl()).f(str2).a(z).d(navigateMessage.getTabsStr()).e(navigateMessage.getTabRightButtonStr()).i(navigateMessage.getPopUpForBackButtonStr()).h(preloadKey).a(100);
        }
        if (z) {
            aj.a(activity, 1);
        }
        if (navigateMessage.popSelf()) {
            activity.overridePendingTransition(0, 0);
            activity.finish();
        }
    }

    public void c(Activity activity, String str) {
        String path = ((PathData) WebRegister.GSON.a(str, PathData.class)).getPath();
        if (this.f18924b.get().a(path.contains("?") ? path.substring(0, path.indexOf("?")) : path)) {
            this.f18925c.get().i(path);
        }
    }

    public PopData a(Activity activity, Intent intent) {
        PopData popData = (PopData) WebRegister.GSON.a(intent.getStringExtra("popData"), PopData.class);
        if (popData == null || popData.getCount() <= 0) {
            return popData;
        }
        a(activity, popData);
        return null;
    }

    private void a(Activity activity, PopData popData) {
        Intent intent = new Intent();
        popData.setCount(popData.getCount() - 1);
        intent.putExtra("popData", WebRegister.GSON.b((Object) popData));
        activity.setResult(-1, intent);
        activity.finish();
    }
}
